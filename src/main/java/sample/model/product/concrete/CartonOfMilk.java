package sample.model.product.concrete;

import sample.model.product.Product;

public class CartonOfMilk extends Product {
    public CartonOfMilk() {
        super(60, 2);
    }

    @Override
    protected boolean isAvailable() {
        return products.stream().anyMatch(product -> product instanceof CartonOfMilk);
    }

    @Override
    public String getName() {
        return "CartonOfMilk";
    }
}