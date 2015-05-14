package gameServer.client;


import gameServer.models.PointModel;

import javax.websocket.*;
import java.io.IOException;

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
            startSendingPosition();
        }

    }

    private void startSendingPosition() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        session.getBasicRemote().sendText(new PointModel(3, 5).toString());
                        Thread.sleep(1000);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
