package sample.controller.task.concrete;

import sample.controller.task.Processable;

public class SewingFactoryTask implements Processable {
    private int duration = 6;

    @Override
    public boolean process() {
        --duration;
        // TODO
        return duration == 0;
    }
}
