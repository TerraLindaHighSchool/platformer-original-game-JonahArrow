import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinSplash extends World
{
    private final float GRAVITY = 0.0866f;
    private final GreenfootSound MUSIC = new GreenfootSound("victory.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 2;
    private final Class NEXT_LEVEL = WinSplash.class;
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public WinSplash()
    {
        super(1200, 800, 1);
        prepare();
    }
    
    private void restart()
    {
        if(Greenfoot.isKeyDown("r"))
        {
            MUSIC.stop();
            Greenfoot.setWorld(new Level1());
        }
    }
    
    private void prepare()
    {
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class, Exit.class,Wall.class, HUD.class);
            Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, 
                MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player,43,760);
    }
}
