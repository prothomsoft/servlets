package servlets.tags;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import servlets.model.Movie;

public class OptionsTag extends SimpleTagSupport implements DynamicAttributes{

    private List<Movie> optionsList;

    private Map<String, Object> tagAttrs = new HashMap<String, Object>();

    public void setOptionsList(List optionsList) {
        this.optionsList = optionsList;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("Hello from options tag");
        for(Movie options : optionsList) {
            out.println(options.getName() + options.getGenre());
        }

        for(String attrName : tagAttrs.keySet()) {
            out.println(attrName);
        }
    }

    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        tagAttrs.put(localName, value);
    }
}