package servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BeerRequestFilter implements Filter{

    private FilterConfig fc;

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
            ServletException {

        fc.getServletContext().log("BeerRequestFilter called");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.fc = config;
        fc.getServletContext().log("BeerRequestFilter initialized");
    }

    public void destroy() {
        fc.getServletContext().log("NullFilter destroyed");
    }
}
