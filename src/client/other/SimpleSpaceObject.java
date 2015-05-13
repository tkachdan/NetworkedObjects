package client.other;

import java.awt.*;

/**
 * The simplest way to make a "concrete" SpaceObject--using the Polygon class to provide most of the behavior
 * @author sdexter72
 *
 */

public class SimpleSpaceObject implements SpaceObject {
	
	/**
	 * Simple space objects can be represented by a single polygon.
	 */
	public client.other.Polygon shape;
	
	/**
	 * The only constructor, hooks up with Polygon constructor
	 * @param blockShape an array of Points specifying the shape of the Polygon (see Polygon docs)
	 * @param point initial position of the Polygon in space
	 * @param inRotation initial rotation of the Polygon
	 */
	public SimpleSpaceObject(Point[] blockShape, Point point, double inRotation) {
		shape = new client.other.Polygon(blockShape, point, inRotation);
	}



	@Override
	public void paint(Graphics g) {
		shape.paint(g);
	}

	@Override
	public void collide(SpaceObject obj) {    
		
	}

	@Override
	public void move(int x, int y) {
		 
		shape.move(x,y);
		
		
	}

	@Override
	public void rotate(double r) {
		shape.rotate(r);
	}

}
