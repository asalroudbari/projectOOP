package sample.model.factory.concretes;

import sample.model.Payable;
import sample.model.factory.Factory;
import sample.model.product.Product;
import sample.model.product.concrete.CartonOfMilk;
import sample.model.product.concrete.IceCream;

public class IceCreamFactory extends Factory {

    public IceCreamFactory() {
        buildCost = 550;
    }

    @Override
    public IceCream produce(Product input) {
        if (!(input instanceof CartonOfMilk))
            return null;
        return null;
    }
}
