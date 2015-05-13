package client.other;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/** @author Mikhail
*Controlled Object class is going to be a ship
*User will be able to control ship
*Movement allowed will be strictly up / down
*Left right
*Keyboard is hooked into that class
**/
public class ControlledObject implements SpaceObject, KeyListener{
   KeyListener keyboard;
   SpaceObject spaceObject;
   int health = 15;
   public ControlledObject(SpaceObject spaceObject){
   this.spaceObject = spaceObject;

   }

   @Override
   public void move(int x, int y) {

       spaceObject.move(x,y);

   }



   @Override
   public void rotate(double r) {
       // TODO Auto-generated method stub

   }

   @Override
   public void paint(Graphics g) {
       // TODO Auto-generated method stub
       spaceObject.paint(g);


   }
   /**
    * Collisions - work on one object
    */
   @Override
   public void collide(SpaceObject obj) {
           Point offset = ((SimpleSpaceObject) obj).shape.getOffset();
           boolean collide = ((SimpleSpaceObject) spaceObject).shape.contains(offset);

           if (collide == true) {
               System.err.println("Collide !!!");

           }

       }
   /**
    * Collisions - work on one object, however, do not work for arraylist of objects
    * can't figure out what the error is for now.
    */


  public boolean isColliding(SpaceObject object) {

           Point offset = ((SimpleSpaceObject) object).shape.getOffset();
           boolean collide = ((SimpleSpaceObject) spaceObject).shape.contains(offset);

           if (collide == true) {
               System.err.println("Collide !!!");
               return true;
           }
           return false;
   }

   @Override
   public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
             spaceObject.move(-15, 0);
           if (e.getKeyCode() == KeyEvent.VK_RIGHT)
               spaceObject.move(15, 0);
           if (e.getKeyCode() == KeyEvent.VK_UP)
               spaceObject.move(0, -15);
           if (e.getKeyCode() == KeyEvent.VK_DOWN)
               spaceObject.move(0, 15);

   }

   @Override
   public void keyReleased(KeyEvent arg0) {
       // TODO Auto-generated method stub

   }

   @Override
   public void keyTyped(KeyEvent arg0) {
       // TODO Auto-generated method stub

   }
   /**
    *
    * Implemented potential health of the controlled object
    * once the object collide with asteroid its hp is getting
    * decreased
    *
    */
   public int getHealth(SpaceObject object){
       if (this.isColliding(object)){
           health--;
           System.out.println(health);
       }
       return health;
   }

   /**
    *
    * Implement potential loose situation if hp goes lower than 0
    * Means player is dead for now it is a rude close of game
    * However in the future menu can be implemented saying that player
    * died and showing score he recieved.
    *
    */
   public boolean isDead(SpaceObject object){
       if (health < 0){
           System.out.println("you are dead");
           System.exit(0);
       }
       return false;
   }


}