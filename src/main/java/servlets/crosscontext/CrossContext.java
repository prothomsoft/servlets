package servlets.crosscontext;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/crossContext")
public class CrossContext extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext ctx = req.getServletContext().getContext("/crossContextTester");
        req.setAttribute("MESSAGE", "Hello There!");
        RequestDispatcher dispatcher = ctx.getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(req, resp);
    }

}
