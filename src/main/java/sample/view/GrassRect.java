package sample.view;

import javafx.scene.shape.Rectangle;


public class GrassRect extends Rectangle {

    // todo  ** add grass class



    public GrassRect(double x , double y){
        sizeHandle(x,y);
        Picture.setRectIMG(this,Picture.GRASS_PATH);
    }


    private void sizeHandle(double x ,double y){
        this.setX(x-25+MainGround.xYard);
        this.setY(y-25+MainGround.yYard);
        this.setWidth(50);
        this.setHeight(50);
    }
}
