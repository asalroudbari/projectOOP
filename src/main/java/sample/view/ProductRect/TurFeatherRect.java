package sample.view.ProductRect;

import javafx.application.Platform;
import sample.controller.LevelCommands;
import sample.model.MyStore;
import sample.model.Products;
import sample.view.Picture;

import java.util.Timer;
import java.util.TimerTask;

public class TurFeatherRect extends ProductRect {

    public static int FEATHER_NUMBER = 5;

    public TurFeatherRect(double x, double y, LevelCommands levelCommands) {
        super(x, y,levelCommands);
        product = Products.TUR_FEATHER;
        Picture.setRectIMG(this,Picture.TU_FEATHER);
        this.getLevelCommands().getMainGround().getRoot().getChildren().add(this);
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Platform.runLater(() -> TurFeatherRect.this.getLevelCommands().getMainGround().getRoot().getChildren()
                            .remove(TurFeatherRect.this));
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
            if(store.canAdd(Products.TUR_FEATHER.capacity)) {
                timer.cancel();
                store.addToStore(Products.TUR_FEATHER.capacity);
                store.setFeatherNumber(store.getFeatherNumber()+1);
                this.getLevelCommands().getMainGround().getRoot().getChildren().remove(this);
            }
        });
    }

    @Override
    protected void sizeHandle(double x, double y) {
        super.sizeHandle(x, y);
        this.setX(x-20);
        this.setY(y-20);
        this.setWidth(40);
        this.setHeight(40);
    }
}
