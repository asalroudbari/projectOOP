package sample.model.factory.concretes;

import sample.model.Payable;
import sample.model.factory.Factory;
import sample.model.product.Product;
import sample.model.product.concrete.Egg;
import sample.model.product.concrete.Flour;

public class Mill extends Factory {

    public Mill() {
        buildCost = 150;
    }

    @Override
    public Flour produce(Product input) {
        if (!(input instanceof Egg))
            return null;
        return null;
    }
}
