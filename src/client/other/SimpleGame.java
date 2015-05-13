package client.other;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


/**
 * A very simple example of how to use the Game base class.
 * 
 * Here, we provide a constructor for our game, override the JPanel
 * paintComponent() method, and write a simple main() method that creates and
 * starts the game.
 * 
 * @author sdexter72
 *
 */
public class SimpleGame extends Game implements KeyListener{

	/**
	 * The lone 'object' in our simple game.
	 * Adding Another object that will simulate FallingSpinningAsteroid
	 * And Ship that is being controlled by Keyboard input
	 */
	/**
	 * The lone 'object' in our simple game.
	 * Adding Another object that will simulate FallingSpinningAsteroid
	 * And Ship that is being controlled by Keyboard input
	 */
	ArrayList<FallingSpinningObject> blockList;
	FallingSpinningObject block;
	ControlledObject ship;
	/**
	 * This constructor invokes the super constructor, then creates a ship
	 * object (which doesn't do very much)
	 * 
	 * @param name
	 * @param inWidth
	 * @param inHeight
	 */
	public SimpleGame(String name, int inWidth, int inHeight) {
       
		super(name, inWidth, inHeight);
		blockList = new ArrayList();
		setBackground(Color.BLACK);
		setFocusable(true);
		client.other.Point[] shipShape = { new client.other.Point(210, 100), new client.other.Point(190, 90),
				new client.other.Point(200, 100), new client.other.Point(190, 110) };

		//ship = new ControlledObject(new SimpleSpaceObject(shipShape, new Point(200, 200), -90));
		
		client.other.Point[] blockShape = { new client.other.Point(200, 100), new client.other.Point(200, 100),
				new client.other.Point(200, 150), new client.other.Point(150, 150), new client.other.Point(150, 100) };
		
		client.other.Point[] flyingShape = { new client.other.Point(210, 100), new client.other.Point(190, 90),
				new client.other.Point(200, 100), new client.other.Point(190, 110) };
		
		//block = new FallingSpinningObject(new SimpleSpaceObject(blockShape, new Point(200,200), -90));
	    ship = new ControlledObject(new SimpleSpaceObject(flyingShape, new client.other.Point(200,200), -90));
	    this.addKeyListener(ship);
	    //block = new FallingSpinningObject(new SimpleSpaceObject(blockShape, new Point(Math.random() * 400, Math.random() * 400), -90));
	    // generating 5 asteroids at random location;
	    Random rad = new Random();
		for (int i = 0; i < 5; i++) {
			FallingSpinningObject block = new FallingSpinningObject(
					new SimpleSpaceObject(blockShape, new client.other.Point(rad.nextInt(350 - 50) + 50, 200), -90.0));
			blockList.add(block);
		}
	}
	

	/**
	 * Draw the ship in white.
	 */

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		ship.paint(g);
		
		//Creating list of blocks 
		for (FallingSpinningObject block : blockList) {
			block.paint(g);
		}
		//creating collisions with every block
		for (FallingSpinningObject block : blockList) {
			ship.collide(block.fallSpinObject);
		}
		//updating health from collisions of every block
		for (FallingSpinningObject block : blockList) {
			ship.getHealth(block.fallSpinObject);
		}
		//checking if ship is dead after collision with every block
		for (FallingSpinningObject block : blockList){
			ship.isDead(block.fallSpinObject);
		}
		
	}


	/**
	 * In main, we create a new SimpleGame, make sure it has the keyboard focus
	 * (which it will need when we implement code to control game action with
	 * keyboard), and start the game.
	 * 
	 * @param args
	 */

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	

	/**
	 * Draw the ship in white.
	 */

	
}