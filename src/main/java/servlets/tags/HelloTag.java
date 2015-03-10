package servlets.tags;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {

    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public void setJspBody(JspFragment jspBody) {
        super.setJspBody(jspBody);
    }

    @Override
    public void setJspContext(JspContext pc) {
        super.setJspContext(pc);
    }

    // called only when the tag is invoked from WITHIN another tag
    @Override
        public void setParent(JspTag parent) {
        super.setParent(parent);
    }

    @Override
    public void doTag() throws JspException, IOException {
        getJspContext().setAttribute("message", "message inside JSP tag");
        JspWriter out = getJspContext().getOut();
        out.println("...</br>");
        getJspBody().invoke(null);
        out.println("...</br>");
        out.println("Hello Custom Tag!" + user);
    }
}
