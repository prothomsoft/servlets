package servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class NullFilter implements Filter {

    private FilterConfig fc;

    public void destroy() {
        fc.getServletContext().log("NullFilter destroyed");
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        fc.getServletContext().log("NullFilter called");
        chain.doFilter(req, res);
    }

    public void init(FilterConfig fc) throws ServletException {
        this.fc = fc;
        fc.getServletContext().log("NullFilter initialized");
    }
}