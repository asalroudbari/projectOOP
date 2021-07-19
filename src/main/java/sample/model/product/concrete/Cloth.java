package sample.model.product.concrete;

import sample.model.product.Product;

public class Cloth extends Product {
    public Cloth() {
        super(50, 2);
    }

    @Override
    protected boolean isAvailable() {
        return products.stream().anyMatch(product -> product instanceof Cloth);
    }

    @Override
    public String getName() {
        return "Cloth";
    }
}
