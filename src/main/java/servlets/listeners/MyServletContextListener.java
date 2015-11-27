package servlets.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;

import servlets.questions.q2.DynamicAddedServlet;

@WebListener
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

        Dynamic dn = sc.addServlet("DynamicAddedServlet", DynamicAddedServlet.class);
        dn.setAsyncSupported(true);
        dn.addMapping("/added");
    }
}