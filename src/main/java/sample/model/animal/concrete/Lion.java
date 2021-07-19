package sample.model.animal.concrete;

import sample.model.animal.Wild;

public class Lion extends Wild {
    private static final int duration = 1;


    public Lion(int x, int y) {
        super(x, y);
        speed = 1;
        sellPrice = 300;
        hitsToKill = 3;
    }


    @Override
    public String toString() {
        return "L";
    }

    @Override
    public String getName() {
        return "Lion";
    }

    @Override
    public int getCapacity() {
        return 15;
    }
}
