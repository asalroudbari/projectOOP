package sample.view;

import javafx.animation.Transition;
import javafx.util.Duration;
import sample.model.HelpingType;
import sample.view.AnimalsRect.FarmAnimalRect;
import sample.view.AnimalsRect.HelpingRect;
import sample.view.AnimalsRect.MyRectAngle;
import sample.view.AnimalsRect.WildRect;
import sample.view.ProductRect.ProductRect;

public class Animation extends Transition {

    private int theta;

    private int speed;

    private MyRectAngle rect ;

    public Animation(MyRectAngle rect, int theta , int speed){
        this.theta = theta ;
        this.speed =speed ;
        this.rect = rect ;
        this.setCycleDuration(Duration.seconds(1.8));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        double dx = speed * Math.cos(Math.toRadians(theta));
        double dy = - speed * Math.sin(Math.toRadians(theta));
        rect.move(dx,dy);
        if(rect.hitTopWall()) theta *= -1 ;
        if(rect.hitDownWall()) theta *= -1 ;
        if(rect.hitLeftWall() || rect.hitRightWall()) theta = 180 -theta ;
        if(rect.getClass() == WildRect.class ){
            for (FarmAnimalRect farm : rect.getLevelCommands().getFarms()) {
                if(rect.hasCollision(farm)){
                    Music.playAction(Music.BEAR_GROWL);
                    System.out.println("boom");
                    rect.getLevelCommands().removeFarmAnimal(farm);
                    break;
                }
            }
        }
        else if(rect.getClass() == HelpingRect.class){
            HelpingRect helpingRect = (HelpingRect)rect;
            if(helpingRect.getHelpingType() == HelpingType.Cat){
                for (ProductRect product : rect.getLevelCommands().getProducts()) {
                    if(rect.hasCollision(product)){
                        rect.getLevelCommands().captureProduct(product);
                    }
                }
            }
            else{
                for (WildRect wild : rect.getLevelCommands().getWilds()) {
                    if(rect.hasCollision(wild)){
                        rect.getLevelCommands().captureWildAnimal(wild);
                    }
                }
            }
        }
        else {
            for (GrassRect grassRect : rect.getLevelCommands().getGrassRects()) {
                if(rect.hasCollision(grassRect)){
                    FarmAnimalRect farmRect = (FarmAnimalRect)rect;
                    farmRect.hunger = farmRect.hunger + 7 ;
                    if(farmRect.hunger >=20){
                        farmRect.hunger = 10 ;
                        farmRect.produce();
                        System.out.println(farmRect.hunger);
                        System.out.println("salam");
                    }
                    System.out.println("yam yam");
                    try {
                        rect.getLevelCommands().getGrassRects().remove(grassRect);
                        rect.getLevelCommands().getMainGround().getRoot().getChildren().remove(grassRect);
                        break;
                    }catch (Exception e){
                    }
                }
            }
        }
    }
}
