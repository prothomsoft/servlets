package servlets.controler;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlets.listeners.BeerSessionListener;
import servlets.listeners.SessionBindingActivationListener;
import servlets.model.BeerExpert;

public class BeerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

    public BeerServlet() {
        super();
    }

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    String color = request.getParameter("color");

	    BeerExpert beerExpert = new BeerExpert();
	    List brands = beerExpert.getBrands(color);
	    request.setAttribute("brands", brands);

	    String adminEmail = getServletConfig().getInitParameter("adminEmail");
	    request.setAttribute("adminEmail", adminEmail);

	    Enumeration<String> emailNames = getServletConfig().getInitParameterNames();

	    StringBuilder emails = new StringBuilder();
        while (emailNames.hasMoreElements()) {
            String emailName = emailNames.nextElement();
            String email = getServletConfig().getInitParameter(emailName);
            emails.append(email);
        }
        request.setAttribute("emailNames", emails.toString());

        SessionBindingActivationListener dog = (SessionBindingActivationListener) getServletContext().getAttribute("dog");
        request.setAttribute("breed", dog.getBreed());

        String sessionStatus = "Old";
        HttpSession session = request.getSession();
        session.setAttribute("sessionAttribute", sessionStatus);
        session.setMaxInactiveInterval(20*60); // after 20 minutes when not used should be destroyed
        if(session.isNew()) {
            sessionStatus = "New";
        }

        request.setAttribute("sessionStatus", sessionStatus);

        // how to set cookies
        String cookieName = "Tomek from Cookies";
        Cookie cookie = new Cookie("username", cookieName);
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);

        // how to read cookies
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            Cookie cookie2 = cookies[i];
            if (cookie2.getName().equals("username")) {
                String userName = cookie2.getValue();
                request.setAttribute("cookie", userName);
            }
        }

        //get session information from listener
        int activeSessions = BeerSessionListener.getActiveSessions();
        request.setAttribute("activeSessions", activeSessions);

	    RequestDispatcher view = request.getRequestDispatcher("result.jsp");
	    view.forward(request, response);




	    //response.sendRedirect("http://www.google.pl");
	}
}