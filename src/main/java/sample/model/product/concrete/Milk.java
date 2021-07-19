package sample.model.product.concrete;

import sample.model.product.Product;

public class Milk extends Product {
    public Milk() {
        super(25, 1);
    }

    @Override
    protected boolean isAvailable() {
        return products.stream().anyMatch(product -> product instanceof Milk);
    }

    @Override
    public String getName() {
        return "Milk";
    }
}
