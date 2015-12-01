package servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import servlets.wrappers.CompressionResponseWrapper;

public class MyCompressionFilter implements Filter{

    FilterConfig fc;

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
            ServletException {

        HttpServletResponse response = (HttpServletResponse) resp;
        CompressionResponseWrapper wrappedResponse = new CompressionResponseWrapper(response);
        fc.getServletContext().log("MyCompressionFilter called");
        chain.doFilter(req, wrappedResponse);
    }

    public void init(FilterConfig fc) throws ServletException {
        this.fc = fc;
        fc.getServletContext().log("MyCompressionFilter initialized");
    }

    public void destroy() {
        fc.getServletContext().log("NullFilter destroyed");
    }

}