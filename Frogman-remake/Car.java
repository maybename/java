import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class Car here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Car extends Actor
{
    /**
     * Act - do whatever the Car wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed = 2; 
    private Direction direction = Direction.LEFT;
    private int countDown = 0;
    private boolean overdroveFrog = false;
    private Track currentTrack;
    private boolean added = true;
    private MyWorld w;
    
    public void setSpeed(int speed){
        if(speed < 0){
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
    
    public void act()
    {   
        if (added){
            added = false;
            w = (MyWorld) this.getWorld();
            setSpeed(
                  (int) w.getRandom()*(currentTrack.getMaxSpeed() - currentTrack.getMinSpeed())+currentTrack.getMinSpeed()
                  );
            setLocation(200,currentTrack.getY());
            
        }
        Frog frog = (Frog) this.getOneIntersectingObject(Frog.class);        
        if (frog != null){
            frog.die();
            overdroveFrog = true;
        }else if (overdroveFrog){
            speed = 0;
        }
        
        rotate();
        if (this.isTouching(Car.class)){
            speed = 0;
            countDown = 1000;
            return;
        }
        
        if (countDown > 0){
            countDown --;
            return;
        }
        
        this.move(this.speed);
        int world_length = this.getWorld().getWidth();
        if (this.getX() < 2){
            this.setLocation(world_length + 200, this.getY());
        }
    }
    
    public Car(Track track)
    {   
        GreenfootImage img = this.getImage();
        img.scale(150, 75);
        this.setImage(img);
        currentTrack = track;
        
        rotate();
        //setSpeed(MyWorld.randomNumbers.nextInt(7) + 2);
    }
}
