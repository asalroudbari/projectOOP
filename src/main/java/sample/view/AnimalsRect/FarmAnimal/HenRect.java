package sample.view.AnimalsRect.FarmAnimal;

import sample.controller.LevelCommands;
import sample.model.Products;
import sample.view.AnimalsRect.FarmAnimalRect;
import sample.view.Picture;
import sample.view.ProductRect.EggHenRect;

public class HenRect extends FarmAnimalRect {

    public static int HEN_NUMBER = 0 ;

    public HenRect(int theta, int speed, LevelCommands levelCommands) {
        super(theta, speed,levelCommands);
        HEN_NUMBER++;
        products = Products.HEN_EGG;
        Picture.setRectIMG(this,Picture.HEN);
    }
    private Products products;

    public void produce(){
         EggHenRect eggHenRect = new EggHenRect(this.getX(),this.getY(),this.getLevelCommands());
        try {
            this.getLevelCommands().getMainGround().getRoot().getChildren().add(eggHenRect);
        }catch (IllegalArgumentException exception){
            System.out.println("wow");
            //todo why error ?
        }
    }
}
