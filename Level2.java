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
    private final int MAX_POWERUP = 2;
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
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class, Exit.class,Wall.class, HUD.class);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, 
                MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player,43,760);
        Exit exit = new Exit();
        addObject(exit,1160,60);
        exit.setLocation(1165,46);
        Floor floor = new Floor();
        addObject(floor,600,800);
        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,200,700);
        SmBrickWall smBrickWall2 = new SmBrickWall();
        addObject(smBrickWall2,500,600);
        SmBrickWall smBrickWall3 = new SmBrickWall();
        addObject(smBrickWall3,800,600);
        Rock rock = new Rock(GRAVITY);
        addObject(rock,850,785);
        Trapdoor trapdoor = new Trapdoor(GRAVITY);
        addObject(trapdoor,350,650);
        SmBrickWall smBrickWall6 = new SmBrickWall();
        addObject(smBrickWall6,950,475);
        Gem gem2 = new Gem();
        addObject(gem2,1160,770);
        SmBrickWall smBrickWall7 = new SmBrickWall();
        addObject(smBrickWall7,500,250);
        SmBrickWall smBrickWall8 = new SmBrickWall();
        addObject(smBrickWall8,680,330);
        SmBrickWall smBrickWall9 = new SmBrickWall();
        addObject(smBrickWall9,380,250);
        SmBrickWall smBrickWall10 = new SmBrickWall();
        addObject(smBrickWall10,1160,120);
        exit.setLocation(1160,60);
        Wall wall = new Wall();
        addObject(wall, -20, 600);
        Wall wall2 = new Wall();
        addObject(wall2, 1220, 600);
        Spider spider = new Spider();
        addObject(spider, 1200, 770);
        Bomb bomb = new Bomb();
        addObject(bomb, 350, 770);
        Gem gem = new Gem();
        addObject(gem, 100, 100);
        Trapdoor trapdoor2 = new Trapdoor(GRAVITY);
        addObject(trapdoor2, 100, 200);
        Spider spider2 = new Spider();
        addObject(spider2, 1200, 570);
        Rock rock2 = new Rock(GRAVITY);
        addObject(rock2,500, 570);
        Rock rock3 = new Rock(GRAVITY);
        addObject(rock3, 350, 220);
        Spider spider3 = new Spider();
        addObject(spider3, 380, 220);
    }
    
    private void spawn()
    {
        if(Math.random() < 0.005)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
}
