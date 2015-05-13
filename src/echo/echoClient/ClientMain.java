package echo.echoClient;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

/**
 * Created by dan on 13.5.15.
 */
public class ClientMain {
    public static void main(String[] args) throws IOException, DeploymentException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://localhost:8025/websocket/echo";
        container.connectToServer(ClientAnnotated.class, URI.create(uri));

    }
}
