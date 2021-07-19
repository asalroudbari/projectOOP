package sample.view.AnimalsRect;

import javafx.application.Platform;
import sample.controller.LevelCommands;
import sample.model.WildType;
import sample.util.MathUtil;
import sample.view.Animation;
import sample.view.MainGround;
import sample.view.Picture;

import java.util.Timer;
import java.util.TimerTask;

public class WildRect extends MyRectAngle {

    private int time ; // should get it from phase 1

    Animation animation;

    private Timer creatTimer;

    public WildRect( int time , WildType wildType, LevelCommands levelCommands){
        super(levelCommands);
        this.wildType = wildType;
        this.time = time;
        //animation = new Animation(this,78,4);
        sizeHandle(MathUtil.generateNumber(MainGround.LEFT_YARD+5,MainGround.RIGHT_YARD-5),MathUtil.generateNumber(
                MainGround.TOP_YARD+5,MainGround.BOTTOM_YARD-5
        ));
        creatTimer = new Timer();
        if(wildType == WildType.BEAR ) Picture.setRectIMG(this,Picture.BEAR);
        else if(wildType == WildType.TIGER) Picture.setRectIMG(this,Picture.TIGER);
        else Picture.setRectIMG(this,Picture.LION);
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()  -> animation = new Animation(WildRect.this,45,3));
                Platform.runLater(() -> animation.play());
                Platform.runLater(() -> WildRect.this.getLevelCommands().getWilds().add(WildRect.this));
                Platform.runLater(() -> WildRect.this.getLevelCommands().getMainGround().getRoot()
                        .getChildren().add(WildRect.this));
                System.out.println("hi");
                creatTimer.cancel();
            }
        };
        creatTimer.schedule(timerTask,1000*time,1);
        tapRect();
    }


    protected void sizeHandle(double x ,double y){
        this.setX(x-33);
        this.setY(y-33);
        this.setWidth(66);
        this.setHeight(66);
    }

    private WildType wildType ;

    private Timer cageTimer;

    public boolean isHarming() {
        return Harming;
    }

    private void tapRect(){
        this.setOnMouseClicked( e ->{
            if(Harming){
                goToCage();
            }
            else {
                freeAnimation();

                // todo : handle transport

                Platform.runLater(() -> WildRect.this.getLevelCommands().
                        getMainGround().getRoot().getChildren().remove(WildRect.this));
            }
        });
    }

    private boolean Harming = true ;

    private void freeAnimation(){
        this.animation.stop();
    }

    public void goToCage(){
        Harming = false;
        if(wildType == WildType.BEAR ) Picture.setRectIMG(this,Picture.BEAR_CAGE);
        else if(wildType == WildType.TIGER) Picture.setRectIMG(this,Picture.TIGER_CAGE);
        else Picture.setRectIMG(this,Picture.LION_CAGE);
        animation.stop();
        System.out.println("fuck");
        cageTimer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                Platform.runLater(() -> freeAnimation());
                Platform.runLater(() -> WildRect.this.getLevelCommands().getWilds().remove(WildRect.this));
                Platform.runLater(() -> WildRect.this.getLevelCommands().
                        getMainGround().getRoot().getChildren().remove(WildRect.this));
                cageTimer.cancel();
            }
        } ;
        cageTimer.schedule(timerTask,7000,1);
    }

}