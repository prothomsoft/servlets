package servlets.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {

    public void requestDestroyed(ServletRequestEvent arg0) {
        System.out.println("request destroyed");
    }

    public void requestInitialized(ServletRequestEvent arg0) {
        System.out.println("request initialized");
    }

}
