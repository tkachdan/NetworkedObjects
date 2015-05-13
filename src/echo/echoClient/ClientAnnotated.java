package echo.echoClient;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;

/**
 * Created by dan on 13.5.15.
 */
@ClientEndpoint
public class ClientAnnotated {

    @OnOpen
    public void onOpen(Session p) {
        try {
            p.getBasicRemote().sendText("Hello!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println(String.format("%s %s", "Received message: ", message));
    }

    public static void main(String[] args) {

    }
}
