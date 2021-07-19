package sample.model.animal.concrete;

import sample.model.Ground;
import sample.model.animal.Helping;
import sample.util.RandomUtil;

public class Cat extends Helping {

    public Cat(int x, int y) {
        super(x, y);
        price = 150;
    }

    @Override
    public String toString() {
        return "Ca";
    }
}
