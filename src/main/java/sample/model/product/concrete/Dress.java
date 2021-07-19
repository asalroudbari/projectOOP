package sample.model.product.concrete;

import sample.model.product.Product;

public class Dress extends Product {
    public Dress() {
        super(100, 4);
    }

    @Override
    protected boolean isAvailable() {
        return products.stream().anyMatch(product -> product instanceof Dress);
    }

    @Override
    public String getName() {
        return "Dress";
    }
}
