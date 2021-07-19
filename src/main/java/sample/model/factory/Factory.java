package sample.model.factory;

import sample.model.Payable;
import sample.model.product.Product;

public abstract class Factory implements Payable {
    protected static int buildCost;
    protected int numOfProducts;
    public boolean isWorking = false;
    public boolean isAvailable = false;

    public Factory() {
    }

    @Override
    public int getPrice() {
        return buildCost;
    }

    public abstract Product produce(Product input);



}
