package servlets.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent arg0) {
        System.out.println("request attribute added");
    }

    public void attributeRemoved(ServletRequestAttributeEvent arg0) {
        System.out.println("request attribute removed");
    }

    public void attributeReplaced(ServletRequestAttributeEvent arg0) {
        System.out.println("request attribute replaced");
    }
}