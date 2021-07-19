package sample.view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public abstract class Picture  {


    private static Picture picture ;

    private static void createPicture(){
        if(picture == null){
            picture = new Picture() {};
        }
    }

    public static void setIconImage(Stage stage,String path){
        createPicture();
        Image image;
        image = new Image( picture.getClass().getResource(path).toExternalForm());
        stage.getIcons().add(image);
    }


    public static void setBackgroundImage(VBox vBox, String path,double width,double height){
        createPicture();
        Image image;
        image = new Image( picture.getClass().getResource(path).toExternalForm());
        vBox.setBackground(new Background(new BackgroundFill(new ImagePattern(image,0,0,width,height,false), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public static void setRectIMG(Rectangle rectIMG , String path){
        createPicture();
        rectIMG.setOpacity(1);
        Image image = null;
        image = new Image( picture.getClass().getResource(path).toExternalForm());
        rectIMG.setFill(new ImagePattern(image));
    }

    public static final String GRASS_PATH = "/Images/grass.jpg";

    public static final String STORE_PATH = "/Images/store.png";

    public static final String HELI_PATH = "/Images/heli.png";

    public static final String TU_FEATHER = "/Images/feather.png";

    public static final String HEN_EGG ="/Images/hen_egg.jpg";

    public static final String MILK = "/Images/milk1.png";

    public static final String CAT ="/Images/cat.png";

    public static final String DOG = "/Images/dog.jpg";

    public static final String LION ="/Images/lion.png";

    public static final String LION_CAGE ="/Images/lion_in_cage.jpg";

    public static final String TIGER = "/Images/tiger.png";

    public static final String TIGER_CAGE = "/Images/tiger_cage.jpg";

    public static final String BEAR = "/Images/bear.jpg";

    public static final String BEAR_CAGE ="/Images/bear_cage.png";

    public static final String FLOUR = "/Images/flour.png";

    public static final String BUF ="/Images/buffalo.png";

    public static final String CAKE = "/Images/cake.jpg";

    public static final String ICON_IMAGE = "/Images/icon.png";

    public static final String HEN = "/Images/chicken.png";

    public static final String TUR = "/Images/tur.jpg";

    public static final String WOOL = "/Images/wool.png";

    public static final String CAKE_BAKERY = "/Images/bakery.png";

    public static final String DRY_EGG_COMPANY = "/images/dry_egg.png";

    public static final String MAKE_HEN = "/Images/jooje_kesh.png";

}