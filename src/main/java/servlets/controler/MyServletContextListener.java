package servlets.controler;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import servlets.model.Dog;

public class MyServletContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void contextInitialized(ServletContextEvent event) {
        // TODO Auto-generated method stub
        ServletContext sc = event.getServletContext();
        String dogBreed = sc.getInitParameter("breed");
        Dog dog = new Dog(dogBreed);
        sc.setAttribute("dog", dog);
    }

}
