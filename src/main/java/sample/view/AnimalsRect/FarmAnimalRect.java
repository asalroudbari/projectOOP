package sample.view.AnimalsRect;

import javafx.scene.shape.Rectangle;
import sample.controller.LevelCommands;
import sample.view.AnimalsRect.MyRectAngle;
import sample.view.Animation;

public class FarmAnimalRect extends MyRectAngle {

    private int theta;

    private int speed;

    public int hunger = 10 ;


    public FarmAnimalRect(int theta , int speed, LevelCommands levelCommands ){
        super(levelCommands);
        animation = new Animation(this,theta,speed);
        animation.play();
    }



    private Animation animation ;

    public Animation getAnimation() {
        return animation;
    }

    public boolean hasCollision(Rectangle rect){
        return this.getBoundsInParent().intersects(rect.getBoundsInParent());
        // i think it works
    }

    public void produce(){

    }


    private void fillPicture(){

    }

}
