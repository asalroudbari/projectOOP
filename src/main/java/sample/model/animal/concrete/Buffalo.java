package sample.model.animal.concrete;

import sample.model.animal.Domestic;

public class Buffalo extends Domestic {

    public Buffalo(int x, int y) {
        super(x, y);
        produceTime = 5;
        price = 400;
    }


    @Override
    public String toString() {
        return "Bu";
    }
}
