package sample.model.factory.concretes;

import sample.model.Payable;
import sample.model.factory.Factory;
import sample.model.product.Product;
import sample.model.product.concrete.CartonOfMilk;
import sample.model.product.concrete.Milk;

public class MilkPacketingFactory extends Factory {

    public MilkPacketingFactory() {
        buildCost = 400;
    }


    @Override
    public CartonOfMilk produce(Product input) {
        if (!(input instanceof Milk))
            return null;
        return null;
    }
}
