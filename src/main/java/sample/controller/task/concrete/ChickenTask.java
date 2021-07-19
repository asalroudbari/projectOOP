package sample.controller.task.concrete;

import sample.controller.task.Processable;

public class ChickenTask implements Processable {
    private int duration = 2;

    @Override
    public boolean process() {
        --duration;
        // TODO
        return duration == 0;
    }
}
