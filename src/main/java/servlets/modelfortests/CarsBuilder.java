package servlets.modelfortests;

public class CarsBuilder {
    private Supplier wheelsSupplier;
    public CarsBuilder(Supplier wheelsSupplier) {
        this.wheelsSupplier = wheelsSupplier;
    }
    public void buildCar() {
        System.out.println("before");
        wheelsSupplier.getElement(4);
        System.out.println("after");
    }
}