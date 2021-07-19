package sample.model.factory.concretes;

import sample.model.Payable;
import sample.model.factory.Factory;
import sample.model.product.Product;
import sample.model.product.concrete.Bread;
import sample.model.product.concrete.Flour;

public class Bakery extends Factory {


    public Bakery() {
        buildCost = 250;
    }


    @Override
    public Bread produce(Product input) {
        if (!(input instanceof Flour))
            return null;
        return null;
    }

}
