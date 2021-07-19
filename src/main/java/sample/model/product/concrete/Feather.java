package sample.model.product.concrete;

import sample.model.product.Product;

public class Feather extends Product {
    public Feather() {
        super(20, 1);
    }

    @Override
    protected boolean isAvailable() {
        return products.stream().anyMatch(product -> product instanceof Feather);
    }

    @Override
    public String getName() {
        return "Feather";
    }
}
