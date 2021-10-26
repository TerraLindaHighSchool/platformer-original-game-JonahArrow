import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int speed;
    private boolean exists;
    public Bullet(int speed)
    {
        this.speed = speed;
        exists = true;
    }
    /**int
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        shootLeft();
        shootRight();
        onCollision();
        if(!exists) getWorld().removeObject(this);
    }
    
    private void shootLeft()
    {
        if(speed == 10)
        {
            move(-10);
        }
    }
    
    private void shootRight()
    {
        if(speed == 5)
        {
            move(10);
        }
    }
    
    private void onCollision()
    {
        if(isTouching(Spider.class))
        {
            removeTouching(Spider.class);
            exists = false;
        }
        
        if(isTouching(Shield.class))
        {
            removeTouching(Shield.class);
            exists = false;
        }
    }
}
