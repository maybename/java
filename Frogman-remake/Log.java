import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Log here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Log extends Actor
{
    private int speed = 2;
    private Direction direction = Direction.LEFT;
    private River currentRiver;
    private boolean firstRun = true;
    private World w;
    public void setSpeed(int speed){
        if (speed < 0){
            return;
        }
        this.speed = speed;
    }
    public int getSpeed(){
        return speed;
    }
    
    public void setDirection(Direction d){
        this.direction = d;
    }
    public Direction getDirection(){
        return(this.direction);
    }
    
    private void rotate(){
        switch(direction){
                case LEFT: this.setRotation(180); break;
                case RIGHT: this.setRotation(0); break;
                case UP: this.setRotation(-90); break;
                case DOWN: this.setRotation(90); break;
        }
    }
    
    
    /**
     * Act - do whatever the Log wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        if (firstRun){
            rotate();
            firstRun = false;
            w = this.getWorld();
        }
        
        this.move(this.speed);
        
        Frog a = (Frog) this.getOneIntersectingObject(Frog.class);
        if (a != null && a.isAlive()){
            if(direction == Direction.LEFT){ 
                a.setLocation(a.getX() - this.speed, a.getY());
            } else {
                a.setLocation(a.getX() + this.speed, a.getY());
            }
        }

        
        if (this.getX() < 2 && direction == Direction.LEFT){
            this.setLocation(w.getWidth(), this.getY());
            return;
        }
        if (this.getX() > w.getWidth()-2 && direction == Direction.RIGHT){
            this.setLocation(0, this.getY());
            return;
        }
    }
    
    public Log(River river)
    {   
        GreenfootImage img = this.getImage();
        img.scale(150, 75);
        this.setImage(img);
        currentRiver = river;
        setSpeed(river.getSpeed());
        this.setDirection(river.getDirection());
        //setSpeed(MyWorld.randomNumbers.nextInt(7) + 2);
    }
}
