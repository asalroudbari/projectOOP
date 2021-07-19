package sample.model.animal.concrete;

import sample.model.animal.Wild;

public class Bear extends Wild {
    public Bear(int x, int y) {
        super(x, y);
        speed = 1;
        sellPrice = 400;
        hitsToKill = 4;
    }

    @Override
    public String toString() {
        return "Be";
    }

    @Override
    public String getName() {
        return "Bear";
    }

    @Override
    public int getCapacity() {
        return 15;
    }
}
