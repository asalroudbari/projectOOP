package sample.view.ProductRect;

import javafx.application.Platform;
import javafx.scene.shape.Rectangle;
import sample.controller.LevelCommands;
import sample.model.MyStore;
import sample.model.Products;
import sample.view.Picture;

import java.util.Timer;
import java.util.TimerTask;

public class WoolRect extends ProductRect {

    public static int WOOL_NUMBER = 0;

    public WoolRect(double x, double y, LevelCommands levelCommands) {
        super(x, y,levelCommands);
        product = Products.WOOL;
        WOOL_NUMBER ++;
        Picture.setRectIMG(this,Picture.WOOL);
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Platform.runLater(() -> WoolRect.this.getLevelCommands().getMainGround().getRoot().getChildren()
                            .remove(WoolRect.this));
                }catch (Exception e){

                }
                timer.cancel();
            }
        };
        timer.schedule(timerTask,5000,1);
        clicked();
    }
    private Timer timer;

    public void clicked(){
        this.setOnMouseClicked(e ->{
            MyStore store = this.getLevelCommands().getStore();
            if(store.canAdd(Products.WOOL.capacity)) {
                timer.cancel();
                store.addToStore(Products.WOOL.capacity);
                store.setWoolNumber(store.getWoolNumber()+1);
                this.getLevelCommands().getMainGround().getRoot().getChildren().remove(this);
            }
        });
    }
}
