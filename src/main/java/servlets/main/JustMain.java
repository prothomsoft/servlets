package servlets.main;

public class JustMain {
    public static void main(String[] args) {
        TemplateComponent templateComponent = new TemplateComponent();
        String readTemplateContent = templateComponent.readTemplateContent("domel.txt");
        System.out.println(readTemplateContent);
    }
}
