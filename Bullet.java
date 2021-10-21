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
    
    public Bullet(int speed)
    {
        this.speed = speed;
    }
    /**int
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        shootLeft();
        shootRight();
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
        if(isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
}
