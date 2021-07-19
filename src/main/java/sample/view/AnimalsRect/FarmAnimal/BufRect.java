package sample.view.AnimalsRect.FarmAnimal;

import sample.controller.LevelCommands;
import sample.model.Products;
import sample.view.AnimalsRect.FarmAnimalRect;
import sample.view.Picture;
import sample.view.ProductRect.WoolRect;

public class BufRect extends FarmAnimalRect {
    public BufRect(int theta, int speed, LevelCommands levelCommands) {
        super(theta, speed,levelCommands);
        Picture.setRectIMG(this,Picture.BUF);
        product = Products.WOOL;
    }

    private Products product;

    public void produce(){
        WoolRect woolRect = new WoolRect(this.getX(),this.getY(),this.getLevelCommands());
        try {
            this.getLevelCommands().getMainGround().getRoot().getChildren().add(woolRect);
        }catch (IllegalArgumentException exception){
            System.out.println("wow");
            //todo why error ?
        }
    }

    @Override
    protected void sizeHandle(double x, double y) {
        super.sizeHandle(x, y);
        this.setX(x-30);
        this.setY(y-30);
        this.setWidth(60);
        this.setHeight(60);
    }
}
