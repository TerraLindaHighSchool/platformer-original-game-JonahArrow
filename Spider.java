import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spider extends Actor
{
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(2);
        turnOnCollision();
    }
    
    private void turnOnCollision()
    {
        if(isTouching(Rock.class))
        {
            turn(180);
        }
        if(isTouching(Wall.class))
        {
            turn(180);
        }
    }
}