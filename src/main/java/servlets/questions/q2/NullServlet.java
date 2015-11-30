package servlets.questions.q2;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlets.main.TemplateComponent;

public class NullServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TemplateComponent templateComponent = new TemplateComponent();

        ServletContext servletContext = req.getServletContext();
        String readTemplateContentWeb = templateComponent.readTemplateContent(servletContext, "/resource/webdomel.txt");

        String parameter = req.getParameter("var");

        String readTemplateContent = templateComponent.readTemplateContent("domel.txt");
        resp.getWriter().println(readTemplateContent);
        resp.getWriter().println(readTemplateContentWeb);

        String[] parameterValues = req.getParameterValues("var");
        resp.getWriter().println("[" + parameter + "]");
        resp.getWriter().println(Arrays.toString(parameterValues));
    }
}
