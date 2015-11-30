package servlets.initializers;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyServletContainerInitializer implements ServletContainerInitializer {

    public void onStartup(Set<Class<?>> arg0, ServletContext arg1) throws ServletException {
        System.out.println("--- CONTAINER INITIALIZER! ---");
    }
}