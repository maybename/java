import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Obecná třída zvířete
 * 
 * @author Lukáš Rýdlo
 * @version 1.0
 */
public class Animal extends Actor
{
    //Atributy
    private   Random randomGen = new Random();
    
    private int    speed = 2;
    private double movingProbability = 0.5;
    private int    rotationDegreesMax = 10;
    private double rotationProbability = 0.1;

    
    protected void setSpeed(int speed) {
        this.speed = speed;
    }
    
    protected int getSpeed() {
        return this.speed;
    }
    
    protected void setMovingProbability(double probability) {
        this.movingProbability = probability;
    }
    
    protected double getMovingProbability() {
        return this.movingProbability;
    }
    
    protected void setMaxRotationDegrees(int degrees) {
        this.rotationDegreesMax = degrees;
    }
    
    protected int getMaxRotationDegrees() {
        return this.rotationDegreesMax;
    }
    
    protected void setRotationProbability(double probability) {
        this.rotationProbability = probability;
    }
    
    protected double getRotationProbability() {
        return this.rotationProbability;
    }
    
    /**
     * Činnost zvířete v jednom kroku běhu programu
     */
    
    public void act() 
    {
        if (this.randomGen.nextDouble()<=this.rotationProbability) {
            this.setRotation((this.getRotation()+this.randomGen.nextInt(this.rotationDegreesMax)-this.rotationDegreesMax/2)%360);
        }
        if (this.randomGen.nextDouble()<=this.movingProbability) {
            this.move(this.speed);
        }
    }    
}
