package gameServer.client;

import client.other.Point;
import gameServer.models.MessageType;

import javax.websocket.*;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dan on 13.5.15.
 */
@ClientEndpoint
public class ClientAnnotated {
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) throws IOException, EncodeException {
        System.out.println("message = " + message);
        if (message.equals("Game started")) {
            System.out.println("Client:Game started");
            // TODO: redo with controller and PositionHolder and other stuff
            startSendingPosition();
        }

    }

    private void startSendingPosition() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        session.getBasicRemote().sendText(new Point(3, 5).toString());
                        Thread.sleep(1000);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
