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
    private boolean start = true;
    private State state = State.ALIVE;
    public void reset(){
        Greenfoot.setWorld(new MyWorld());
    }
    public void act()
    {
        if (start){
            this.setImage("empty.png");
            start = false;
        }
        if(done){
            if(state == State.DEAD){
                this.setImage("empty.png");
                this.reset();
            }
            return;
        }
        for(Frog f: this.getWorld().getObjects(Frog.class)){
            if(f.isAlive() != true){
                // System.out.println("You died...");
                state = State.DEAD;
                this.setImage("dead.png");
                this.sleepFor(500);
                done = true;
            }
            if(f.getY() < 80){
                // System.out.println("You won...");
                state = State.WIN;
                this.setImage("win.png");
                this.sleepFor(500);
                done = true;
            }
        }
    }
}
