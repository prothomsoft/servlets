package servlets.listeners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent arg0) {
        System.out.println("context attribute added");
    }

    public void attributeRemoved(ServletContextAttributeEvent arg0) {
        System.out.println("context attribute removed");

    }

    public void attributeReplaced(ServletContextAttributeEvent arg0) {
        System.out.println("context attribute replaced");
    }

}
