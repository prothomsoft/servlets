package servlets.questions.q37;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/InitParamServlet"}, name="InitParamServlet", initParams=@WebInitParam(name="var1", value="Howdy!"))
public class InitParamServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String initParameter1 = getInitParameter("var1");
        String initParameter2 = getServletContext().getInitParameter("var1");
        resp.getWriter().println(initParameter1);
        resp.getWriter().println(initParameter2);
        resp.getWriter().println("InitParamServlet");
    }
}
