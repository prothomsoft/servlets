package servlets.wrap;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/simpleservlet")
public class SimpleFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig config) throws ServletException {
        context = config.getServletContext();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        String requestURL = req.getRequestURL().toString();
        context.log("Requesting URL: "+requestURL+" Time:"+new Date());
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
