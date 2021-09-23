import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Obstacle extends Actor
{
    /**
     * Act - do whatever the Obstacle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected abstract void fall();
    
    // Returns true of child object is on the platform
    protected boolean isOnGround()
    {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2,
                                            Platform.class);
        return ground != null;
    }
    
    // Removes child objects no longer in scene
    protected void removeOutOfBounds(Obstacle obstacle)
    {
        if(obstacle.getY() > getWorld().getHeight() +
                            obstacle.getImage().getHeight() / 2)
        {
            getWorld().removeObject(obstacle);
        }
    }
    
}
