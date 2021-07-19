package sample.controller.task.concrete;

import sample.controller.task.Processable;
import sample.model.TruckAgent;

public class TruckOffLoadingTask implements Processable {
    private String itemName;

    public TruckOffLoadingTask(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean process() {
        TruckAgent.offLoad(itemName);
        return true;
    }
}
