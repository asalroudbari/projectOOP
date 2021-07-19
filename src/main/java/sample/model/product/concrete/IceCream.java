package sample.model.product.concrete;

import sample.model.product.Product;

public class IceCream extends Product {
    public IceCream() {
        super(120, 4);
    }

    @Override
    protected boolean isAvailable() {
        return products.stream().anyMatch(product -> product instanceof IceCream);
    }

    @Override
    public String getName() {
        return "IceCream";
    }
}
