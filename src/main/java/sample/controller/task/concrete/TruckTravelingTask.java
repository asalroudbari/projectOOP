package sample.controller.task.concrete;

import sample.controller.task.Processable;
import sample.model.TruckAgent;

public class TruckTravelingTask implements Processable {
    private int duration = 10;

    @Override
    public boolean process() {
        --duration;
        if (duration == 0) {
            TruckAgent.stopTruck();
            return true;
        }
        return false;
    }
}
