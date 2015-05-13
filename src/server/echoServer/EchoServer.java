package server.echoServer;

import org.glassfish.tyrus.server.Server;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by dan on 13.5.15.
 */
@ServerEndpoint(value = "/echo")
public class EchoServer {
    @OnMessage
    public String onMessage(String message, Session session) {
        return message;
    }

    public static void runServer() {
        Server server = new Server("localhost", 8025, "/websocket", null, EchoServer.class);

        try {
            server.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please press a key to stop the server.");
            reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }

    public static void main(String[] args) {
        runServer();
    }
}