package sample.controller.task.concrete;

import sample.controller.task.Processable;

public class IceCreamFactoryTask implements Processable {
    private int duration = 7;


    @Override
    public boolean process() {
        --duration;
        //TODO
        return duration == 0;
    }
}
