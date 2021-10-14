import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Level2 extends World
{
    private final float GRAVITY = 0.0866f;
    private final GreenfootSound MUSIC = new GreenfootSound("incompetech_tribal.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = Level2.class;
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level2()
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
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class,Exit.class, HUD.class);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, 
                           MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player,43,760);
        Exit exit = new Exit();
        addObject(exit,1160,60);
        exit.setLocation(1165,46);
        Floor floor = new Floor();
        addObject(floor,600,800);
        Bomb bomb = new Bomb(GRAVITY);
        addObject(bomb,150,770);
        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,400,700);
        SmBrickWall smBrickWall2 = new SmBrickWall();
        addObject(smBrickWall2,620,600);
        SmBrickWall smBrickWall3 = new SmBrickWall();
        addObject(smBrickWall3,740,600);
        SmBrickWall smBrickWall4 = new SmBrickWall();
        addObject(smBrickWall4,950,500);
        Trapdoor trapdoor = new Trapdoor(GRAVITY);
        addObject(trapdoor,1070,500);
        SmBrickWall smBrickWall5 = new SmBrickWall();
        addObject(smBrickWall5,1190,500);
        Gem gem = new Gem();
        addObject(gem,1150,425);
        Bomb bomb2 = new Bomb(GRAVITY);
        addObject(bomb2,1070,770);
        BrickWall brickWall = new BrickWall();
        addObject(brickWall,550,400);
        Bomb bomb3 = new Bomb(GRAVITY);
        addObject(bomb3,660,360);
        Trapdoor trapdoor2 = new Trapdoor(GRAVITY);
        addObject(trapdoor2,150,360);
        SmBrickWall smBrickWall6 = new SmBrickWall();
        addObject(smBrickWall6,60,225);
        SmBrickWall smBrickWall7 = new SmBrickWall();
        addObject(smBrickWall7,500,250);
        SmBrickWall smBrickWall8 = new SmBrickWall();
        addObject(smBrickWall8,200,120);
        SmBrickWall smBrickWall9 = new SmBrickWall();
        addObject(smBrickWall9,320,120);
        Bomb bomb4 = new Bomb(GRAVITY);
        addObject(bomb4,250,80);
        BrickWall brickWall2 = new BrickWall();
        addObject(brickWall2,860,120);
        SmBrickWall smBrickWall10 = new SmBrickWall();
        addObject(smBrickWall10,1160,120);
        exit.setLocation(60,1160);
    }
    
    private void spawn()
    {
        if(Math.random() < 0.005)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
}
