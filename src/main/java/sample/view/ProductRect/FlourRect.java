package sample.view.ProductRect;

import javafx.scene.shape.Rectangle;
import sample.controller.LevelCommands;
import sample.model.MyStore;
import sample.model.Products;
import sample.view.Picture;

public class FlourRect extends ProductRect {
    public FlourRect(double x, double y, LevelCommands levelCommands) {
        super(x, y,levelCommands);
        product = Products.FLOUR;
        Picture.setRectIMG(this,Picture.FLOUR);
    }

    public void clicked(){
        this.setOnMouseClicked(e ->{
            MyStore store = this.getLevelCommands().getStore();
            if(store.canAdd(Products.FLOUR.capacity)) {
                store.addToStore(Products.FLOUR.capacity);
               store.setFlourNumber(store.getFlourNumber()-1);
            }
            //this.getLevelCommands().getMainGround().getRoot().getChildren().remove(this);
        });
    }
}
