package sample.model.factory.concretes;

import sample.model.Payable;
import sample.model.factory.Factory;
import sample.model.product.Product;
import sample.model.product.concrete.Cloth;
import sample.model.product.concrete.Dress;

public class SewingFactory extends Factory {


    public SewingFactory() {
        buildCost = 400;
    }


    @Override
    public Dress produce(Product input) {
        if (!(input instanceof Cloth))
            return null;
        return null;
    }
}
