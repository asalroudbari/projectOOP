package sample.model.factory.concretes;

import sample.model.factory.Factory;
import sample.model.product.Product;
import sample.model.product.concrete.Cloth;
import sample.model.product.concrete.Feather;

public class ClothFactory extends Factory {

    public ClothFactory() {
        buildCost = 250;
    }

    @Override
    public Cloth produce(Product input) {
        if (!(input instanceof Feather))
            return null;

        return null;
    }

}
