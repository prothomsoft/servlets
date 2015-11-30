package servlets.questions.q2;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/foo/*")
public class NullServletResource extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream is = getServletContext().getResourceAsStream("/test.jsp");

        String realPath = getServletContext().getRealPath("/test.jsp");
        resp.getWriter().println(realPath);

        byte[] b = new byte[is.available()];
        is.read(b);
        resp.getWriter().print(new String(b));
    }
}