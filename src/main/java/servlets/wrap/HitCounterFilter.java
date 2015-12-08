package servlets.wrap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/simpleservlet")
public class HitCounterFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig config) throws ServletException {
        context = config.getServletContext();
        context.setAttribute("hitCount", new Integer(0));
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        int i = ((Integer)context.getAttribute("hitCount")).intValue();
        i++;
        context.setAttribute("hitCount", new Integer(i));

        DummyResponse dummyResponse = new DummyResponse((HttpServletResponse)response);
        chain.doFilter(request, dummyResponse); // pass the request,dummy response along the filter chain
        //chain.doFilter(request, response);

        PrintWriter out = response.getWriter();
        out.println(dummyResponse.toString());
        out.println("<b>Your are the "+i+" Visitor</b>");
        out.close();

    }

    public void destroy() {
        // TODO Auto-generated method stub

    }



}
