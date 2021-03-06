package servlets.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    static private int activeSession;

    public static int getActiveSessions() {
        return activeSession;
    }

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("session created");
        activeSession++;
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("session destroyed");
        activeSession--;
    }
}
