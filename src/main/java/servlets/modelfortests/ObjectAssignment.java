package servlets.modelfortests;

public class ObjectAssignment {

    private Context context;

    public ObjectAssignment(Context context) {
        this.context = context;
    }

    public void displayContextMessage() {
        if(context.equals(Context.J)) {
            callContextJ();
        }
        if(context.equals(Context.C)) {
            callContextC();
        }
    }

    private void callContextC() {
        System.out.println("callContextC");
    }

    private void callContextJ() {
        System.out.println("callContextJ");
    }
}
