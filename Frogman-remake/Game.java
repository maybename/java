import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game extends Actor
{
    private boolean done = false;
    public void reset(){
        Greenfoot.setWorld(new MyWorld());
    }
    public void act()
    {
        if(done){
            this.reset();
            return;
        }
        for(Frog f: this.getWorld().getObjects(Frog.class)){
            if(f.isAlive() != true){
                System.out.println("You died...");
                this.sleepFor(500);
                done = true;
            }
        }
    }
}
