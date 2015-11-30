package servlets.main;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;

public class TemplateComponent {

    public String readTemplateContent(String templatePath) {
        try {
            File templateFile = new File(getClass().getClassLoader()
                    .getResource(templatePath)
                    .getFile());
            return FileUtils.readFileToString(templateFile);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public String readTemplateContent(ServletContext servletContext, String templatePath) {
        try {
            File templateFile = new File(servletContext
                    .getRealPath(templatePath));
            return FileUtils.readFileToString(templateFile);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

}
