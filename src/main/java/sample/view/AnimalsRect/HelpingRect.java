package sample.view.AnimalsRect;

import sample.controller.LevelCommands;
import sample.model.HelpingType;
import sample.model.animal.Helping;
import sample.util.MathUtil;
import sample.view.AnimalsRect.FarmAnimal.HenRect;
import sample.view.Animation;
import sample.view.MainGround;
import sample.view.Picture;

public  class HelpingRect extends MyRectAngle {

    protected void sizeHandle(double x ,double y){
        this.setX(x-22);
        this.setY(y-22);
        this.setWidth(44);
        this.setHeight(44);
    }

    private void freeAnimation(){
        this.animation.stop();
    }

    private Animation animation ;

    private HelpingType helpingType ;

    public HelpingRect(int speed, int theta, HelpingType helpingType, LevelCommands levelCommands){
        super(levelCommands);
        this.helpingType = helpingType;
        sizeHandle(MathUtil.generateNumber(MainGround.LEFT_YARD+5,MainGround.RIGHT_YARD-5),
                MathUtil.generateNumber(MainGround.TOP_YARD+5,MainGround.BOTTOM_YARD-5));
        animation = new Animation(this,theta,speed);
        animation.play();

        if(helpingType == HelpingType.Cat){
            Picture.setRectIMG(this,Picture.CAT);
        }
        else {
            Picture.setRectIMG(this,Picture.DOG);
        }
    }

    public HelpingType getHelpingType() {
        return helpingType;
    }

}
