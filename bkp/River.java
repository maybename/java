import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class River here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class River extends Actor
{
    private int posY = 0;
    private int speed = 2;
    private int maxCount = 3;
    private int count = 0;
    private Direction direction;
    private World w = this.getWorld();
    
    private boolean added = false;
    
    
    public int getY(){return posY;}
    public int getSpeed(){return speed;}
    public int getMaxCount(){return maxCount;}
    public int getCount(){return count;}
    public Direction getDirection(){return direction;}
    
    public boolean addLog(){
        if (count >= maxCount){
            return false;
        }
        count ++;
        return true;
    }
    
    public boolean removeLog(){
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
    public River(int Y, int speed, int maxCount, Direction direction){
        posY = Y;
        
        this.speed = speed;
        this.maxCount = (maxCount > 0) ? maxCount : 0;
        this.direction = (direction == Direction.UP || direction == Direction.DOWN)? Direction.LEFT:direction;
    }
    public void Act(){
        if (added){
            return;
        }
        GreenfootImage bkg_img = this.getImage();
        bkg_img.scale(w.getWidth(),80);
        this.setImage(bkg_img);
    }
}
