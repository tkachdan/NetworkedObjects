package gameServer.server;

import gameServer.decoders.UpstreamDecoder;
import gameServer.util.SessionHolder;
import org.glassfish.tyrus.server.Server;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by dan on 13.5.15.
 */
@ServerEndpoint(value = "/game", decoders = UpstreamDecoder.class)
public class GameServer {

    @OnOpen
    public void onOpen(Session session) throws IOException {
        SessionHolder sessionHolder = SessionHolder.getInstance();
        sessionHolder.addUser(session);
        HashSet<Session> connectedUsers = sessionHolder.getConnectedUsers();
        if (connectedUsers.size() == 2) {
            for (Session connectedUser : connectedUsers) {
                connectedUser.getBasicRemote().sendText("Game started");
            }
        } else {
            session.getBasicRemote().sendText("Waiting for user to connect");
        }
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println("message = " + message);
        return message;
    }

    @OnError
    public void onError(Throwable t) {
        t.printStackTrace();
    }

    @OnClose
    public void onClose(Session session) {

    }

    public static void runServer() {
        Server server = new Server("localhost", 8025, "/websocket", null, GameServer.class);

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
