package sample.controller.task.concrete;

import sample.controller.task.Processable;
import sample.model.Plant;

public class PlantTask implements Processable {
    private int x;
    private int y;

    public PlantTask(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean process() {
        Plant.plant(x, y);
        return true;
    }
}
