import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Track here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Track extends Actor
{
    private int posY = 0;
    private int maxSpeed = 8;
    private int minSpeed = 1;
    private int maxCount = 3;
    private int count = 0;
    private Direction direction;
    private World w = this.getWorld();
    
    public int getY(){return posY;}
    public int getMaxSpeed(){return maxSpeed;}
    public int getMinSpeed(){return minSpeed;}
    public int getMaxCount(){return maxCount;}
    public int getCount(){return count;}
    public Direction getDirection(){return direction;}
    
    public boolean addCar(){
        if (count >= maxCount){
            return false;
        }
        count ++;
        return true;
    }
    
    public boolean removeCar(){
        if (count <= 0){
            return false;
        }
        count --;
        return true;
    }
    
    public void setY(int Y){
        if(Y < 0){
            return;
        }
        if(Y > w.getHeight()){
            return;
        }
        posY = Y;
    }
    public Track(int Y, int maxSpeed, int minSpeed, int maxCount, Direction direction){
        posY = Y;
        this.maxSpeed = maxSpeed;
        this.minSpeed = minSpeed;
        this.maxCount = (maxCount > 0) ? maxCount : 0;
        this.direction = (direction == Direction.UP || direction == Direction.DOWN)? Direction.LEFT:direction;
    }
}
