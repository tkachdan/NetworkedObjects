package gameServer.models;

import java.awt.*;

/**
 * 
 * @author Mikhail
 *Class FallingSpinningObject will give properties of 
 *Falling and Spinning to object it is applied to
 *Objects should always be floating down - imitation of gravity
 *Perhaps it will be more interesting to implement rand method to make different asteroid 
 *Go down with different speeds
 *
 */
public class FallingSpinningObject implements SpaceObject {
	
	public SpaceObject fallSpinObject;
	
	public FallingSpinningObject(SpaceObject fallSpinObject){

		this.fallSpinObject=fallSpinObject;
		
	}
	@Override
	public void move(int x, int y) {
	fallSpinObject.move(x,y);
		
	}

	@Override
	public void rotate(double r) {
	fallSpinObject.rotate(r);
	}
    //here we spin and rotate objects at constant speed - consider giving random
	@Override
	public void paint(Graphics g) {
	move(0,1);
	rotate(1);
	fallSpinObject.paint(g);
	}

	@Override
	public void collide(SpaceObject obj) {
		// TODO Auto-generated method stub
		this.collide(obj);
	}

}