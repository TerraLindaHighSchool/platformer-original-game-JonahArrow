import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level1()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class,Exit.class, HUD.class);
        Player player = new Player();
        addObject(player,43,760);
        Exit exit = new Exit();
        addObject(exit,1143,52);
        exit.setLocation(1165,46);
        Floor floor = new Floor();
        addObject(floor,600,800);
        Bomb bomb = new Bomb();
        addObject(bomb,150,770);
        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,400,700);
        SmBrickWall smBrickWall2 = new SmBrickWall();
        addObject(smBrickWall2,620,600);
        SmBrickWall smBrickWall3 = new SmBrickWall();
        addObject(smBrickWall3,740,600);
        SmBrickWall smBrickWall4 = new SmBrickWall();
        addObject(smBrickWall4,950,500);
        Trapdoor trapdoor = new Trapdoor();
        addObject(trapdoor,1070,500);
        SmBrickWall smBrickWall5 = new SmBrickWall();
        addObject(smBrickWall5,1190,500);
        Gem gem = new Gem();
        addObject(gem,1150,425);
        Bomb bomb2 = new Bomb();
        addObject(bomb2,1070,770);
        BrickWall brickWall = new BrickWall();
        addObject(brickWall,550,400);
        Bomb bomb3 = new Bomb();
        addObject(bomb3,730,360);
        Trapdoor trapdoor2 = new Trapdoor();
        addObject(trapdoor2,150,360);
        SmBrickWall smBrickWall6 = new SmBrickWall();
        addObject(smBrickWall6,60,225);
        Gem gem2 = new Gem();
        addObject(gem2,30,170);
        SmBrickWall smBrickWall7 = new SmBrickWall();
        addObject(smBrickWall7,500,250);
        SmBrickWall smBrickWall8 = new SmBrickWall();
        addObject(smBrickWall8,200,120);
        SmBrickWall smBrickWall9 = new SmBrickWall();
        addObject(smBrickWall9,320,120);
        Bomb bomb4 = new Bomb();
        addObject(bomb4,250,80);
        BrickWall brickWall2 = new BrickWall();
        addObject(brickWall2,860,120);
    }
}
