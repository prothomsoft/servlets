package servlets.initializers;

import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletSecurityElement;

import servlets.questions.q34.MyJar1Servlet;

public class MyServletContainerInitializer implements ServletContainerInitializer {

    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

        try {
            Class klass = Class.forName("servlets.questions.q34.MyJar1Servlet");
            Class<MyJar1Servlet> clazz = klass;

            Servlet s = ctx.createServlet(clazz);
            ServletRegistration.Dynamic d = ctx.addServlet("MyJar1Servlet", s);
            d.addMapping("/MyJar1Servlet");

            ServletSecurityElement servletSecurityElement = new ServletSecurityElement();

        } catch (ClassNotFoundException e) {

        }

    }
}