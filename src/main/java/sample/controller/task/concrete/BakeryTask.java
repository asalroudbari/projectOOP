package sample.controller.task.concrete;

import sample.controller.task.Processable;

public class BakeryTask implements Processable {
    private int duration = 5;

    @Override
    public boolean process() {
        --duration;
        // TODO
        return duration == 0;
    }
}
