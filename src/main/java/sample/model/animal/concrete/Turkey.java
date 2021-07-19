package sample.model.animal.concrete;

import sample.model.animal.Domestic;

public class Turkey extends Domestic {
    public Turkey(int x, int y) {
        super(x, y);
        produceTime = 3;
        price = 200;
    }

    @Override
    public String toString() {
        return "Tu";
    }
}
