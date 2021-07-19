package sample.model.animal;

import sample.model.Ground;
import sample.model.Payable;
import sample.model.product.Product;
import sample.util.RandomUtil;


public abstract class Domestic extends Animal implements Payable {
    protected Product product;
    protected int produceTime;
    protected int price;
    protected int size;

    @Override
    public int getPrice() {
        return price;
    }

    public Domestic(int x, int y) {
        super(x, y);
    }
}
