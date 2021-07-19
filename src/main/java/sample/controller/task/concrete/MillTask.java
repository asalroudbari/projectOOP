package sample.controller.task.concrete;

import sample.controller.task.Processable;

public class MillTask implements Processable {
    private int duration = 4;

    @Override
    public boolean process() {
        --duration;
        // TODO
        return duration == 0;
    }
}