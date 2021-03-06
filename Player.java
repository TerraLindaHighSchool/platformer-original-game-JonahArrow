import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private Health[] health;
    private Powerup[] powerup;
    private int healthCount;
    private int speed;
    private int walkIndex;
    private int frame;
    private int canShoot;
    private float yVelocity;
    private boolean isWalking;
    private boolean isJumping;
    private boolean isFacingLeft;
    private final GreenfootImage[] WALK_ANIMATION;
    private final GreenfootImage STANDING_IMAGE;
    private final float JUMP_FORCE;
    private final float GRAVITY;
    private final Class NEXT_LEVEL;
    private final GreenfootSound MUSIC;
    public Player(int speed, float jumpForce, float gravity, int maxHealth, 
                  int maxPowerUp, Class nextLevel, GreenfootSound music)
    {
        this.speed = speed;
        JUMP_FORCE = jumpForce;
        GRAVITY = gravity;
        NEXT_LEVEL = nextLevel;
        MUSIC = music;
        healthCount = maxHealth;
        health = new Health[maxHealth];
        STANDING_IMAGE = getImage();
        WALK_ANIMATION = new GreenfootImage[]
                        {
                            new GreenfootImage("walk0.png"),
                            new GreenfootImage("walk1.png"),
                            new GreenfootImage("walk2.png"),
                            new GreenfootImage("walk3.png"),
                            new GreenfootImage("walk4.png"),
                            new GreenfootImage("walk5.png"),
                        };
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        walk();
        jump();
        fall();
        onCollision();
        gameOver();
    }
    
    public void addedToWorld(World world) 
    {
        health[0] = new Health();
        world.addObject(health[0], 30, 36);
        health[1] = new Health();
        world.addObject(health[1], 72, 36);
        health[2] = new Health();
        world.addObject(health[2], 114, 36);
    }
    
    private void walk() 
    {
        if(isWalking)
        {
            animator();
        }
        else
        {
            setImage(STANDING_IMAGE);
            walkIndex = 0;
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            if(!MUSIC.isPlaying())
            {
                MUSIC.playLoop();
            }
            if(isFacingLeft)
            {
                mirrorImages();
            }
            isWalking = true;
            isFacingLeft = false;
            move(speed);
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            if(!isFacingLeft)
            {
                mirrorImages();
            }
            isWalking = true;
            isFacingLeft = true;
            move(-speed);
        }
        
        if(!(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left")))
        {
            isWalking = false;
        }
        
        if(Greenfoot.isKeyDown("+"))
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
        
        if(Greenfoot.isKeyDown("space") && (isFacingLeft))
        {
            if(canShoot == 45)
            {
                getWorld().addObject(new Bullet(10),getX(),getY());
                canShoot = 0;
            }
            canShoot++;
        }
        
        if(Greenfoot.isKeyDown("space") && (!isFacingLeft))
        {
            if(canShoot == 45)
            {
                getWorld().addObject(new Bullet(5),getX(),getY());
                canShoot = 0;
            }
            canShoot++;
        }
        
        if(Greenfoot.isKeyDown("r"))
        {
            MUSIC.stop();
            Greenfoot.setWorld(new Level1());
        }
    }
    
    private void jump() 
    {
        if(Greenfoot.isKeyDown("up") && isOnGround())
        {
            yVelocity = JUMP_FORCE;
            isJumping = true;
        }
        
        if(isJumping && yVelocity > 0)
        {
            setLocation(getX(), getY() - (int) yVelocity);
            yVelocity -= GRAVITY;
        }
        else
        {
            isJumping = false;
        }
    }
    
    private void fall() 
    {
        if(!isJumping && !isOnGround())
        {
            setLocation(getX(), getY() - (int) yVelocity);
            yVelocity -= GRAVITY;
        }
    }
    
    private void animator() 
    {
        if(frame % (15 - 2 * speed) == 0) 
        {
            if(walkIndex < WALK_ANIMATION.length)
            {
                setImage(WALK_ANIMATION[walkIndex]);
                walkIndex++;
            }
            else
            {
                walkIndex = 0;
            }
        }
        frame++;
    }
    private void onCollision() 
    {
        if(isTouching(Exit.class))
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
        
        if(isTouching(Bomb.class))
        {
            removeTouching(Bomb.class);
            Greenfoot.playSound("explosionSmall.wav");
            getWorld().removeObject(health[healthCount - 1]);
            healthCount--;
        }
        
        if(isTouching(AcidRain.class))
        {
            removeTouching(AcidRain.class);
            Greenfoot.playSound("jump.wav");
            getWorld().removeObject(health[healthCount - 1]);
            healthCount--;
        }
        
         if(isTouching(Trapdoor.class))
        {
            removeTouching(Trapdoor.class);
            Greenfoot.playSound("door_open.wav");
        }
        
        if(isTouching(Gem.class))
        {
            removeTouching(Gem.class);
            Greenfoot.playSound("collectable.wav");
            if(healthCount < 2)
            {
                getWorld().addObject(health[healthCount + 1],30 + healthCount * 42,36);
                healthCount++;
            }
        }
        
        if((isTouching(Platform.class)) && (!isOnGround()))
        {
            yVelocity = -3;
            fall();
        }
        
        if((isTouching(Wall.class)) && (Greenfoot.isKeyDown("left")))
        {
            move(3);
        }
        
        if((isTouching(Wall.class)) && (Greenfoot.isKeyDown("right")))
        {
            move(-3);
        }
        
        if((isTouching(Rock.class)))
        {
            speed = 1;
        }
        else
        {
            speed = 3;
        }
        
        if(isTouching(Shield.class))
        {
            MUSIC.stop();
            Greenfoot.setWorld(new Level1());
        }
    
    }
    private void mirrorImages() 
    {
        for(int i = 0; i < WALK_ANIMATION.length; i++)
        {
            WALK_ANIMATION[i].mirrorHorizontally();
        }
    }
        private void gameOver() 
    {
        if(healthCount == 0)
        {
            MUSIC.stop();
            Greenfoot.setWorld(new Level1());
        }
    }
    private boolean isOnGround() 
    {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, Platform.class);
        return ground != null;
    }
}
