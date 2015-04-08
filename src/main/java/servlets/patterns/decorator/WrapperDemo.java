package servlets.patterns.decorator;

public class WrapperDemo {

    public static void main(String[] args) {

        TransformText transformer = new BaseWrapper(new Echo());
        show(transformer.render("blah."));

        transformer = new Capitalize(new Echo());
        show(transformer.render("blah."));

        transformer = new RemovePeriods(new Capitalize(new Echo()));
        show(transformer.render("blah."));

        transformer = new RemovePeriods(new Echo());
        show(transformer.render("blah."));
    }

    private static void show(String aText) {
        System.out.println(aText);
    }

    private static final class Echo implements TransformText {
        public String render(String aText) {
            return aText;
        }
    }

    private static class BaseWrapper implements TransformText {
        private TransformText fShowText;
        BaseWrapper(TransformText aTransformText) {
            fShowText = aTransformText;
        }
        public String render(String aInputText) {
            String text = before(aInputText);
            text = fShowText.render(text);
            return after(text);
        }
        String before(String aText) {
            return aText;
        }
        String after(String aText) {
            return aText;
        }
    }

    private static final class Capitalize extends BaseWrapper {
        Capitalize(TransformText aTransformText) {
            super(aTransformText);
        }

        @Override
        String before(String aText) {
            String result = aText;
            if (aText != null) {
                result = result.toUpperCase();
            }
            return result;
        }
    }

    private static final class RemovePeriods extends BaseWrapper {
        RemovePeriods(TransformText aTransformText){
          super(aTransformText);
        }
        @Override String after(String aText) {
          String result = aText;
           if (aText != null){
             result = result.replace(".", "");
           }
           return result;
        }
      }

}
