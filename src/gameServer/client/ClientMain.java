package gameServer.client;

import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by dan on 13.5.15.
 */
public class ClientMain {
    private static CountDownLatch messageLatch;

    public static void main(String[] args) throws IOException, DeploymentException {
        messageLatch = new CountDownLatch(1);

        final ClientEndpointConfig clientEndpointConfig = ClientEndpointConfig.Builder.create().build();
        ClientManager client = ClientManager.createClient();
        String uri = "ws://localhost:8025/websocket/game";

        try {
            messageLatch = new CountDownLatch(1);
            client.connectToServer(ClientAnnotated.class, URI.create(uri));
            messageLatch.await(100, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

