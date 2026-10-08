import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class frog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Frog extends Actor
{
    private Animation animation;
    private boolean move = false;
    private boolean alive = false;
    private boolean start = true;
    private Direction direction = Direction.UP;
    private GreenfootImage deadImg;
    /**
     * Act - do whatever the frog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void die(){
        alive = false;
    }
    
    public boolean isAlive(){
        return alive;
    }
    
    public Direction getDirection(){
        return direction;        
    }
    
    public void makeStep(Direction d){
        direction = d;
        move = true;
    }
    
    private void procInputs(){
        switch(Greenfoot.getKey()){
            case ("w"): makeStep(Direction.UP); break;
            case ("s"): makeStep(Direction.DOWN); break;
            case ("a"): makeStep(Direction.LEFT); break;
            case ("d"): makeStep(Direction.RIGHT); break;
            default: break;
        }
    }
    
    public void act()
    {
        if(alive){
            switch(direction){
                case LEFT: this.setRotation(180); break;
                case RIGHT: this.setRotation(0); break;
                case UP: this.setRotation(-90); break;
                case DOWN: this.setRotation(90); break;
            }
            if (move == true){
                move = false;
                this.move(2);
            }
            animation.run();
            start = false;
        } else{
            this.setImage("deadfrog.png");
        }
    }
    
    public Frog(){
        java.util.List<GreenfootImage> imgs = new GifImage("top.gif").getImages();
        GreenfootImage[] images = new GreenfootImage[imgs.size()];
        for (int i=0; i<imgs.size(); i++) {
            GreenfootImage img = imgs.get(i);
            img.rotate(-90);
            img.scale(150,150);
            images[i] = img;
        }
        animation = new Animation(this, images);
        animation.setCycleActs(148);
        animation.run();
        animation.setActiveState(true);
        
        String filename = "deadfrog.png";
        //deadImg = GreenfootImage(filename);
        
        alive = true;
        this.act();
    }
}
