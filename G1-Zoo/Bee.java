import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Bee extends Animal
{
   
   public void act() {
      if(this.isAtEdge() && this.getX()!=1) {
         this.setLocation(2,(int) (100*Math.sin(1/100.0)+200));
      }
      this.setLocation(this.getX()+1,(int) (100*Math.sin(this.getX()/100.0)+200));
    }
    
   public int getPosX() {
      return this.getX();
   }
}
