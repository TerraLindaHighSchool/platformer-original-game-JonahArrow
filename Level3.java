import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Level3 extends World
{
    private final float GRAVITY = 0.0866f;
    private final GreenfootSound MUSIC = new GreenfootSound("incompetech_tribal.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 2;
    private final Class NEXT_LEVEL = WinSplash.class;
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level3()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false); 
        prepare();
    }
    
    public void act()
    {
        spawn();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class, Exit.class,Wall.class, HUD.class);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, 
                MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player,43,760);
        Floor floor = new Floor();
        addObject(floor,600,800);
        Wall wall = new Wall();
        addObject(wall, -20, 600);
        Wall wall2 = new Wall();
        addObject(wall2, 1220, 600);
        FinalBoss finalBoss = new FinalBoss();
        addObject(finalBoss, 900, 700);
        Shield shield = new Shield();
        addObject(shield, 900, 700);
        Shield shield2 = new Shield();
        addObject(shield2, 900, 700);
        Shield shield3 = new Shield();
        addObject(shield3, 900, 700);
        Shield shield4 = new Shield();
        addObject(shield4, 900, 700);
        Shield shield5 = new Shield();
        addObject(shield5, 900, 700);
        Shield shield6 = new Shield();
        addObject(shield6, 900, 700);
        Shield shield7 = new Shield();
        addObject(shield7, 900, 700);
        Shield shield8 = new Shield();
        addObject(shield8, 900, 700);
        Shield shield9 = new Shield();
        addObject(shield9, 900, 700);
        Shield shield10 = new Shield();
        addObject(shield10, 900, 700);
    }
    
    private void spawn()
    {
        if(Math.random() < 0.05)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
}
