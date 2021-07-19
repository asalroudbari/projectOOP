package sample.view.ProductRect;

import javafx.application.Platform;
import javafx.scene.shape.Rectangle;
import sample.controller.LevelCommands;
import sample.model.MyStore;
import sample.model.Products;
import sample.view.MainGround;
import sample.view.Picture;

import java.util.Timer;
import java.util.TimerTask;

public class EggHenRect extends ProductRect {

    public static  int EGG_NUMBER = 0 ;


    public EggHenRect(double x, double y, LevelCommands levelCommands) {
        super(x, y,levelCommands);
        EggHenRect.this.getLevelCommands().setMainGround(MainGround.getInstance());
        product = Products.HEN_EGG;
        EGG_NUMBER++;
        Picture.setRectIMG(this,Picture.HEN_EGG);
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    Platform.runLater(() -> EggHenRect.this.getLevelCommands().getMainGround().getRoot().getChildren()
                            .remove(EggHenRect.this));
                }catch (Exception e){

                }
                timer.cancel();
            }
        };
        timer.schedule(timerTask,5000,1);
        clicked();
    }

    private Timer timer ;

    public void clicked(){
        this.setOnMouseClicked(e ->{
            MyStore store =  this.getLevelCommands().getStore();
            if(store.canAdd(Products.HEN_EGG.capacity)) {
                timer.cancel();
                store.addToStore(Products.HEN_EGG.capacity);
                store.setEggNumber(store.getEggNumber()+1);
                this.getLevelCommands().getMainGround().getRoot().getChildren().remove(this);
            }

        });
    }
}
