import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Objects here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlienShip extends Objects
{
    private int shootCounter = 0;
    public AlienShip(ScoreBoard sb)
    {
        super(sb);
    }
    
    public void act() 
    {
        // Add your action code here
        move(-8);
        destroyShip();
        shoot();
    }    
    
    public void shoot()
    {
        shootCounter++;
        if(shootCounter >=100)
        {
            getWorld().addObject(new AlienBullet(), getX()-30, getY());
            shootCounter = 0;
        }
    }
    
    public void destroyShip()
    {
        if(isTouching(Bullet.class))
        {
            
            World w = getWorld();
            Explosion bomb = new Explosion();
            w.addObject(bomb, getX(), getY()); 
            removeTouching(Bullet.class);
            get_scoredet().setState("AlienShipHit");
            w.removeObject(this);
            
        }
    }
    
    public void updateScore()
    {
        if(get_scoredet().getState() == "AlienShipHit")
        {
            get_scoredet().set_alienShipsHitCount();
        }
    }

}