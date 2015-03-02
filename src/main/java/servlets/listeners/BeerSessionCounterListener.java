package servlets.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class BeerSessionCounterListener implements HttpSessionListener {

    static private int activeSession;

    public static int getActiveSessions() {
        return activeSession;
    }

    public void sessionCreated(HttpSessionEvent arg0) {
        activeSession++;
    }

    public void sessionDestroyed(HttpSessionEvent arg0) {
        activeSession--;
    }
}
