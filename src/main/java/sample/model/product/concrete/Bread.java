package sample.model.product.concrete;

import sample.model.product.Product;

public class Bread extends Product {
    public Bread() {
        super(80, 4);
    }

    @Override
    protected boolean isAvailable() {
        return products.stream().anyMatch(product -> product instanceof Bread);
//        for (Product product: products) {
//            if(product instanceof Bread) {
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public String getName() {
        return "Bread";
    }
}
