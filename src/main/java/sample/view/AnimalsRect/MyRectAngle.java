package sample.view.AnimalsRect;

import javafx.scene.shape.Rectangle;
import sample.controller.LevelCommands;
import sample.util.MathUtil;
import sample.view.MainGround;

public  class MyRectAngle extends Rectangle {
    public void move (double dx , double dy){
        this.setX( this.getX() + dx );
        this.setY( this.getY() + dy );
    }

    public boolean hitTopWall(){
        return this.getY() <= MainGround.TOP_YARD ;
    }

    public boolean hitDownWall(){
        return this.getY() >= MainGround.BOTTOM_YARD ;
    }

    public boolean hitLeftWall(){
        return this.getX() <= MainGround.LEFT_YARD ;
    }

    public boolean hitRightWall(){
        return this.getX() >= MainGround.RIGHT_YARD ;
    }

    public boolean hasCollision(Rectangle secondBall){
        return this.getBoundsInParent().intersects(secondBall.getBoundsInParent());
    }

    protected void sizeHandle(double x ,double y){
        this.setX(x-22);
        this.setY(y-22);
        this.setWidth(44);
        this.setHeight(44);
    }

    private LevelCommands levelCommands ;

    public LevelCommands getLevelCommands() {
        return levelCommands;
    }

    MyRectAngle(LevelCommands levelCommands){
        this.levelCommands = levelCommands;
        sizeHandle(MathUtil.generateNumber(MainGround.LEFT_YARD+30,
                MainGround.RIGHT_YARD-30),MathUtil.generateNumber(MainGround.TOP_YARD+30,MainGround.BOTTOM_YARD-30));
    }
}
