package sample.view.ProductRect;

import javafx.scene.shape.Rectangle;
import sample.controller.LevelCommands;
import sample.model.Products;
import sample.view.Picture;

import java.util.Timer;

public class BreadRect extends ProductRect {

    private Timer timer;

    public static int BREAD_NUMBER = 0 ;


    public BreadRect(double x, double y, LevelCommands levelCommands) {
        super(x, y,levelCommands);
        product = Products.BREAD;
        BREAD_NUMBER ++;
        Picture.setRectIMG(this,Picture.CAKE);
    }

    public void clicked(){
        this.setOnMouseClicked(e ->{
            timer.cancel();
            if(this.getLevelCommands().getStore().canAdd(Products.BREAD.capacity)) {
                this.getLevelCommands().getStore().addToStore(Products.BREAD.capacity);
            }
            this.getLevelCommands().getMainGround().getRoot().getChildren().remove(this);
        });
    }
}
