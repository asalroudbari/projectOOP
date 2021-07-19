package sample.model.product.concrete;

import sample.model.product.Product;

public class Egg extends Product {
    public Egg() {
        super(15, 1);
    }

    @Override
    protected boolean isAvailable() {
        return products.stream().anyMatch(product -> product instanceof Egg);
    }

    @Override
    public String getName() {
        return "Egg";
    }
}
