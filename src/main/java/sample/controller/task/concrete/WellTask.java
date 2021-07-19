package sample.controller.task.concrete;

import sample.model.Irrigation;
import sample.controller.task.Processable;

public class WellTask implements Processable {
    private int duration = 3;

    @Override
    public boolean process() {
        --duration;
        if (duration == 0) {
            Irrigation.well();
            return true;
        }
        return false;
    }
}
