package sample.model.product.concrete;

import sample.model.product.Product;

public class Flour extends Product {
    public Flour() {
        super(40, 2);
    }

    @Override
    protected boolean isAvailable() {
        return products.stream().anyMatch(product -> product instanceof Flour);
    }

    @Override
    public String getName() {
        return "Flour";
    }
}
