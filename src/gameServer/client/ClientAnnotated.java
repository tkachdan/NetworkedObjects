package gameServer.client;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by dan on 13.5.15.
 */
@ClientEndpoint
public class ClientAnnotated {

    @OnOpen
    public void onOpen(Session p) {

    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println(String.format("%s %s", "Received message: ", message));
    }

    public static void main(String[] args) {

    }
}
