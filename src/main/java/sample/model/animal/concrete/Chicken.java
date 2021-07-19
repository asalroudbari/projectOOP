package sample.model.animal.concrete;

import sample.model.animal.Domestic;

public class Chicken extends Domestic {

    public Chicken(int x, int y) {
        super(x, y);
        produceTime = 2;
        price = 100;
    }

    @Override
    public String toString() {
        return "Ch";
    }
}
