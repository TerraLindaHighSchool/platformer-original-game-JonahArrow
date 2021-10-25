import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spider extends Actor
{
    private int speed;
    
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(speed);
        turnOnCollision();
    }

    private void turnOnCollision()
    {
        if(isTouching(Rock.class))
        {
            speed = 2;
        }
        if(isTouching(Wall.class))
        {
            speed = -2;
        }
    }
}