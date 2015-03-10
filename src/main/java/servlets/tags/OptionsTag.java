package servlets.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import servlets.model.Movie;

public class OptionsTag extends SimpleTagSupport{

    private List<Movie> optionsList;

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
    }
}