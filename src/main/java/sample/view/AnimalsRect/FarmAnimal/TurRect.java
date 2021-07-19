package sample.view.AnimalsRect.FarmAnimal;

import sample.controller.LevelCommands;
import sample.model.Products;
import sample.view.AnimalsRect.FarmAnimalRect;
import sample.view.Picture;
import sample.view.ProductRect.TurFeatherRect;

public class TurRect extends FarmAnimalRect {
    public TurRect(int theta, int speed, LevelCommands levelCommands) {
        super(theta, speed,levelCommands);
        this.product = Products.TUR_FEATHER;
        Picture.setRectIMG(this,Picture.TUR);
    }
    private Products product;

    @Override
    public void produce(){
        System.out.println(this.getLevelCommands());
        TurFeatherRect turFeatherRect = new TurFeatherRect(this.getX(),this.getY(),this.getLevelCommands());
        try {
            this.getLevelCommands().getMainGround().getRoot().getChildren().add(turFeatherRect);
        }catch (IllegalArgumentException exception){
            System.out.println("wow");
            //todo why error ?
        }
    }

}
