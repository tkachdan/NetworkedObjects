package client;

import org.glassfish.grizzly.http.server.Session;
import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

/**
 * Created by dan on 13.5.15.
 */
@ClientEndpoint
public class Client {

    private static CountDownLatch latch;

    private Logger logger = Logger.getLogger(this.getClass().getName());


    @OnMessage
    public String onMessage(String message) {
        // same as above
        System.out.println(message);
        return message;
    }



    public static void main(String[] args) {
        latch = new CountDownLatch(1);

        ClientManager client = ClientManager.createClient();
        try {
            client.connectToServer(Client.class, new URI("ws://localhost:8025/web/game"));
            latch.await();

        } catch (DeploymentException | URISyntaxException | InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}