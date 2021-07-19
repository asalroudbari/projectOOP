package sample.controller.task.concrete;

import sample.controller.task.Processable;
import sample.model.TruckAgent;

public class TruckLoadingTask implements Processable {
    private String itemName;

    public TruckLoadingTask(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean process() {
        TruckAgent.loadTruck(itemName);
        return true;
    }
}
