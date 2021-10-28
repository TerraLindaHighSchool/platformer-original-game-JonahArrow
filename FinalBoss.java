import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinalBoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinalBoss extends Actor
{
    private final Class NEXT_LEVEL;
    private final GreenfootSound MUSIC;
    /**
     * Act - do whatever the FinalBoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        onCollision();
    }
    public FinalBoss(Class nextLevel, GreenfootSound music)
        {
            NEXT_LEVEL = nextLevel;
            MUSIC = music;
        }
    private void onCollision()
    {
        if(isTouching(Bullet.class))
        {
            MUSIC.stop();
            World world = null;
            try
            {
                world = (World) NEXT_LEVEL.newInstance();
            }
            catch (InstantiationException e)
            {
                System.out.println("Class cannot be instantiated");
            } catch (IllegalAccessException e) {
                System.out.println("cannot access class constructor");
            }
            Greenfoot.setWorld(world);
        }
    }
}
