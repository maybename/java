import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.ArrayList;
/**
 * Write a description of class MyWorld here.
 * 
 * @author maybename
 * @version v0.1
 */

public class MyWorld extends World
{
    private ArrayList<Track> carTracks = new ArrayList<Track>();
    
    private Random randomNumbers = new Random();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public float getRandom(){
        return randomNumbers.nextFloat();
    }
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 760, 1);
        this.addObject(new Frog(), 1200/2, 700);
        carTracks.add(new Track(120,8,2,6,Direction.RIGHT));
        carTracks.add(new Track(200,8,2,6,Direction.RIGHT));
        carTracks.add(new Track(280,8,2,6,Direction.RIGHT));
        carTracks.add(new Track(360,8,2,6,Direction.RIGHT));
        carTracks.add(new Track(440,8,2,6,Direction.RIGHT));
        carTracks.add(new Track(520,8,2,6,Direction.RIGHT));
        
        int i = 4;
        while (i > 0){
            int trackNum = (int) getRandom()*carTracks.size();
            Track track = carTracks.get(trackNum);
            if (track.addCar()){
                new Car(track);
                i --;
            }
        }
    
    }
}
