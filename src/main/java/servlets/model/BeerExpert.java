package servlets.model;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {

    public List getBrands(String color) {
        List<String> brands = new ArrayList<String>();
        if(color.equals("light")) {
            brands.add("light one");
            brands.add("light two");
        }
        if(color.equals("dark")) {
            brands.add("dark one");
            brands.add("dark two");
        }
        return brands;
    }
}
