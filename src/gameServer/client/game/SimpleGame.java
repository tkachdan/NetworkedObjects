package gameServer.client.game;

import gameServer.models.ControlledObject;
import gameServer.models.FallingSpinningObject;
import gameServer.models.PointModel;
import gameServer.models.SimpleSpaceObject;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;


public class SimpleGame extends Game implements KeyListener {

    ArrayList<FallingSpinningObject> blockList;
    FallingSpinningObject block;
    ControlledObject ship;

    public SimpleGame(String name, int inWidth, int inHeight) {
        super(name, inWidth, inHeight);
        blockList = new ArrayList();
        Random rad = new Random();
        setBackground(Color.BLACK);
        setFocusable(true);

        PointModel[] shipShape = {new PointModel(210, 100), new PointModel(190, 90),
                new PointModel(200, 100), new PointModel(190, 110)};

        PointModel[] blockShape = {new PointModel(200, 100), new PointModel(200, 100),
                new PointModel(200, 150), new PointModel(150, 150), new PointModel(150, 100)};

        PointModel[] flyingShape = {new PointModel(210, 100), new PointModel(190, 90),
                new PointModel(200, 100), new PointModel(190, 110)};

        ship = new ControlledObject(new SimpleSpaceObject(flyingShape, new PointModel(200, 200), -90));
        this.addKeyListener(ship);

        for (int i = 0; i < 5; i++) {
            FallingSpinningObject block = new FallingSpinningObject(
                    new SimpleSpaceObject(blockShape, new PointModel(rad.nextInt(350 - 50) + 50, 200), -90.0));
            blockList.add(block);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        ship.paint(g);

        for (FallingSpinningObject block : blockList) {
            block.paint(g);
        }
        for (FallingSpinningObject block : blockList) {
            ship.collide(block.fallSpinObject);
        }
        for (FallingSpinningObject block : blockList) {
            ship.getHealth(block.fallSpinObject);
        }
        for (FallingSpinningObject block : blockList) {
            ship.isDead(block.fallSpinObject);
        }

    }


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

}