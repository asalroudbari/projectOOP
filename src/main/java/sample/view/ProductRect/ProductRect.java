package sample.view.ProductRect;

import javafx.scene.shape.Rectangle;
import sample.controller.LevelCommands;
import sample.model.Products;

public class ProductRect extends Rectangle {
    protected void sizeHandle(double x , double y){
        this.setX(x-17);
        this.setY(y-17);
        this.setWidth(34);
        this.setHeight(34);
    }
    private LevelCommands levelCommands;

    public LevelCommands getLevelCommands() {
        return levelCommands;
    }

    public ProductRect(double x, double y,LevelCommands commands){
        sizeHandle(x,y);
        this.levelCommands = commands;
    }

    protected Products product;

    public Products getProduct() {
        return product;
    }
}
