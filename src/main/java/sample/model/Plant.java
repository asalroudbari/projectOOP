package sample.model;

import static sample.model.Ground.GRASS;
import static sample.model.Ground.ground;
import static sample.model.Irrigation.bucketIsEmpty;
import static sample.model.Irrigation.useWater;

public class Plant {

    public static void plant(int x, int y) {
        if(!bucketIsEmpty()) {
            useWater();
            ground[x][y] = GRASS;
        } else {
            System.out.println("Fill the bucket!");
        }
    }

}
