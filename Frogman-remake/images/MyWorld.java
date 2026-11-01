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
    private ArrayList<River> rivers = new ArrayList<River>();
    private int seed = 1384358; 
    private Random randomNumbers = new Random(1);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public float getRandom(){
        return randomNumbers.nextFloat();
    }
    private void loadLevel1(){
        carTracks.add(new Track(120,8,2,6,Direction.LEFT));
        carTracks.add(new Track(200,8,2,6,Direction.RIGHT));
        carTracks.add(new Track(280,8,2,6,Direction.LEFT));
        carTracks.add(new Track(360,8,2,6,Direction.RIGHT));
        carTracks.add(new Track(440,8,2,6,Direction.LEFT));
        carTracks.add(new Track(520,8,2,6,Direction.RIGHT));
        this.addObject(new Frog(), 1200/2, 700);
        River r = new River(520,2,6,Direction.RIGHT);
        rivers.add(r);
        this.addObject(r, 0, r.getY());
    }
    public MyWorld()
    {    
        super(1200, 760, 1);
        //this.setPaintOrder(Log.class,Frog.class,Car.class);
        
        loadLevel1();
        randomNumbers = new Random(seed);
        int carNum = 10;
        while (carNum > 0){
            System.out.println("" + carTracks.size() +" "+ getRandom());
            int trackNum = (int) (getRandom()*carTracks.size());
            Track track = carTracks.get(trackNum);
            if (track.addCar()){
                this.addObject(new Car(track), carNum, track.getY());
                carNum --;
            }
        }
        
        int logNum = 1;
        while (logNum > 0){
            System.out.println("" + rivers.size() +" "+ getRandom());
            int trackNum = (int) (getRandom()*rivers.size());
            River river = rivers.get(trackNum);
            if (river.addLog()){
                this.addObject(new Log(river), logNum, river.getY());
                logNum --;
            }
        }
    }
}
