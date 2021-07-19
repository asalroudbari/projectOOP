package sample.model.animal.concrete;

import sample.model.animal.Helping;

public class Dog extends Helping {

    public Dog(int x, int y) {
        super(x, y);
        price = 100;
    }

    @Override
    public String toString() {
        return "D";
    }
}
