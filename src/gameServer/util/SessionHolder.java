package gameServer.util;

import javax.websocket.Session;
import java.util.HashSet;

/**
 * Created by dan on 13.5.15.
 */
public class SessionHolder {
    private HashSet<Session> connectedUsers;

    public HashSet<Session> getConnectedUsers() {
        return connectedUsers;
    }

    public void setConnectedUsers(HashSet<Session> connectedUsers) {
        this.connectedUsers = connectedUsers;
    }

    public static SessionHolder getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(SessionHolder ourInstance) {
        SessionHolder.ourInstance = ourInstance;
    }

    public void addUser(Session session) {
        connectedUsers.add(session);

    }

    public boolean removeUser(Session session) {
        if (connectedUsers.contains(session)) {
            connectedUsers.remove(session);
            return true;
        } else {
            return false;
        }
    }


    private static SessionHolder ourInstance = new SessionHolder();

    public static SessionHolder getInstance() {
        return ourInstance;
    }

    private SessionHolder() {
        connectedUsers = new HashSet<>();
    }
}
