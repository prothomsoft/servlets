package servlets.main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class TemplateComponentTest {

    @Test
    public void shouldReadTemplate() {
        //given
        String templatePath = "domel.txt";

        //when
        TemplateComponent templateComponent = new TemplateComponent();
        String templateContent = templateComponent.readTemplateContent(templatePath);

        //then
        assertNotNull(templateContent);
        assertEquals("test domel 123", templateContent);
    }

}
