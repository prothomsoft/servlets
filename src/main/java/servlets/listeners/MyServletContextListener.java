package servlets.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void contextInitialized(ServletContextEvent event) {
        // TODO Auto-generated method stub
        ServletContext sc = event.getServletContext();
        String dogBreed = sc.getInitParameter("breed");
        SessionBindingActivationListener dog = new SessionBindingActivationListener(dogBreed);
        sc.setAttribute("dog", dog);
    }

}
