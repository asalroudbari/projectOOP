package sample.model.animal;

import sample.model.Ground;
import sample.model.Payable;
import sample.util.RandomUtil;

public abstract class Helping extends Animal implements Payable {
    @Override
    public int getPrice() {
        return price;
    }

    protected int price;

    public Helping(int x, int y) {
        super(x, y);
    }

    public void killSelfAndWild(Wild wild) {
        animals.remove(this);
        animals.remove(wild); // both wild and helping will die
    }
}
