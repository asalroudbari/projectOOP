package sample.model.animal.concrete;

import sample.controller.task.concrete.GeneralMovement;
import sample.model.Ground;
import sample.model.animal.Wild;
import sample.util.RandomUtil;

public class Tiger extends Wild {
    public Tiger(int x, int y) {
        super(x, y);
        speed = 2;
        sellPrice = 500;
        hitsToKill = 4;
    }

    @Override
    public void generateRandomMove(GeneralMovement.Record record) {
        int step = 2*RandomUtil.randomStep();
        String direction = RandomUtil.randomDirection();
        Ground.ground[x][y] = " ";
        if (direction.equals("X")) {
            x += step;
            if (x < 0) x = 0;
            if (x > 5) x = 5;
        } else {
            y += step;
            if (y < 0) y = 0;
            if (y > 5) y = 5;
        }
        Ground.ground[x][y] = this.toString();
    }

    @Override
    public String toString() {
        return "Ti";
    }

    @Override
    public String getName() {
        return "Tiger";
    }

    @Override
    public int getCapacity() {
        return 15;
    }
}
