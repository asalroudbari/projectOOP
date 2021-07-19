package sample.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.Main;
import sample.controller.LevelCommands;
import sample.model.HelpingType;
import sample.model.MyStore;
import sample.model.WildType;
import sample.util.MathUtil;
import sample.view.AnimalsRect.FarmAnimal.BufRect;
import sample.view.AnimalsRect.FarmAnimal.HenRect;
import sample.view.AnimalsRect.FarmAnimal.TurRect;
import sample.view.AnimalsRect.HelpingRect;
import sample.view.AnimalsRect.WildRect;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class MainGround implements Initializable {
    private static MainGround mainGround = null;
    public static MainGround getInstance(){
        if(mainGround!=null){
            return mainGround;
        }
        else{
            mainGround = new MainGround();
            return mainGround;
        }
    }

    public static final int xYard = 177;

    public static final  int yYard = 242;

    private  final int grassTime = 20000 ;

    public static final int TOP_YARD = 242 ;

    public static final int BOTTOM_YARD = 654;

    public static final int LEFT_YARD = 177;

    public static final int RIGHT_YARD = 922;
    public static Stage stage;
    public Rectangle heli;

    public Rectangle transport;

    public  Label coinsLabel;

    public  Label getCoinsLabel() {
        return coinsLabel;
    }

    public Label timeLabel;

    public Rectangle dryEgg;

    public Rectangle bakery;
    public Rectangle makeHen;

    private int wellWater =MAX_WELL_WATER ;

    public static final int MAX_WELL_WATER = 8 ;

    public static final int WELL_COST = 15;


    public void setWaterLabel(){
        waterLabel.setText(String.valueOf(wellWater)+" / "+String.valueOf(MAX_WELL_WATER));
    }

    public Label waterLabel;

    @FXML
    private AnchorPane root;

    @FXML
    private MenuItem exitBTN;

    @FXML
    private Rectangle well;

    @FXML
    private MenuItem muteBTN;

    @FXML
    private MenuItem MainMenu;

    @FXML
    void muteHit(ActionEvent event) {
        if(Music.mediaPlayer.getStatus() == MediaPlayer.Status.PAUSED){
            Music.mediaPlayer.play();
        }
        else Music.mediaPlayer.pause();
    }//worked

    @FXML
    void MainMenuHit(ActionEvent event) throws IOException {
        Scene welcomeMenu= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/MainMenu.fxml")));
        Main.stage.setScene(welcomeMenu);
        Music.mediaPlayer.pause();
    } //worked

    @FXML
    void exitHit(ActionEvent event) throws IOException {
        Scene mainMenu = new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/MainMenu.fxml")));
        Main.stage.setScene(mainMenu);
        Music.mediaPlayer.pause();
    }  //worked

    Timer gameTimer;
    private int time = 0;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        levelCommands = new LevelCommands();
        Picture.setRectIMG(bakery,Picture.CAKE_BAKERY);
        Picture.setRectIMG(dryEgg,Picture.DRY_EGG_COMPANY);
        Picture.setRectIMG(makeHen,Picture.MAKE_HEN);
        setCoinsLabel();
        System.out.println(Main.currentPlayer.getCoin());
        Music.playMusic();
        Picture.setRectIMG(transport,Picture.STORE_PATH);
        Picture.setRectIMG(heli,Picture.HELI_PATH);
        stage = new Stage();
        gameTimer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                time++;
                if(time%60 >=10) {
                    Platform.runLater(() -> timeLabel.setText(String.valueOf(time / 60)
                            + " : " + String.valueOf(time % 60)));
                }
                else Platform.runLater(() -> timeLabel.setText(String.valueOf(time / 60)
                        + " :0 " + String.valueOf(time % 60)));
            }
        };
        gameTimer.schedule(timerTask,1,1000);
    }

    public void wellHit(MouseEvent mouseEvent) {
        if(levelCommands.getPlayer().getCoin() >= WELL_COST && wellWater == 0){
            Music.playAction(Music.WELL);
            levelCommands.getPlayer().setCoin(levelCommands.getPlayer().getCoin()-WELL_COST);
            setCoinsLabel();
            wellWater = MAX_WELL_WATER;
            setWaterLabel();
        }
    }

    @FXML
    private Rectangle yard;

    public void yardHit(MouseEvent mouseEvent) {

        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        if(wellWater>0) {
            wellWater -- ;
            setWaterLabel();
            GrassRect grassRect = new GrassRect(x, y);
            root.getChildren().add(grassRect);
            levelCommands.getGrassRects().add(grassRect);
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    // todo ** remove from array
                    try {
                        Platform.runLater(() -> root.getChildren().remove(grassRect));
                    } catch (Exception e) {
                        // if it really exist
                    }
                    timer.cancel();
                }
            };
            timer.schedule(timerTask, grassTime, 1);
        }
    }



    public void dogHit(ActionEvent actionEvent) {
        if(levelCommands.getPlayer().getCoin()>=100){
            levelCommands.getPlayer().setCoin(levelCommands.getPlayer().getCoin()-100);
            setCoinsLabel();
            HelpingRect helpingRect = new HelpingRect((int)MathUtil.generateNumber(1,3),
                    (int)MathUtil.generateNumber(0,180), HelpingType.Dog,levelCommands);
            root.getChildren().add(helpingRect);
            levelCommands.getHelpings().add(helpingRect);
        }
    }

    public void catHit(ActionEvent actionEvent) {
        if(levelCommands.getPlayer().getCoin()>=150){
            levelCommands.getPlayer().setCoin(levelCommands.getPlayer().getCoin()-150);
            setCoinsLabel();
            HelpingRect helpingRect = new HelpingRect((int)MathUtil.generateNumber(1,3),(int)MathUtil.generateNumber(0,180)
                    , HelpingType.Cat,levelCommands);
            root.getChildren().add(helpingRect);
            levelCommands.getHelpings().add(helpingRect);
        }

    }

    public void bufHit(ActionEvent actionEvent) {
        if(levelCommands.getPlayer().getCoin()>=400){
            levelCommands.getPlayer().setCoin(levelCommands.getPlayer().getCoin()-400);
            setCoinsLabel();
            BufRect bufRect = new BufRect((int)MathUtil.generateNumber(0,180),(int)MathUtil.generateNumber(1,3),levelCommands);
            levelCommands.getFarms().add(bufRect);
            root.getChildren().add(bufRect);
            levelCommands.getFarms().add(bufRect);
        }

    }

    public void henHit(ActionEvent actionEvent) {
        System.out.println("demn " + levelCommands.getPlayer().getCoin());
        if(levelCommands.getPlayer().getCoin()>=100){
            levelCommands.getPlayer().setCoin(levelCommands.getPlayer().getCoin()-100);
            setCoinsLabel();
            HenRect henRect = new HenRect((int)MathUtil.generateNumber(0,180),(int)MathUtil.generateNumber(1,2)
            ,levelCommands);
            levelCommands.getFarms().add(henRect);
            root.getChildren().add(henRect);


        }

    }

    public void turHit(ActionEvent actionEvent) {
        if(levelCommands.getPlayer().getCoin()>=200){
            levelCommands.getPlayer().setCoin(levelCommands.getPlayer().getCoin()-200);
            setCoinsLabel();
            TurRect turRect = new TurRect((int)MathUtil.generateNumber(0,180),
                    (int)MathUtil.generateNumber(1,3),levelCommands);
            levelCommands.getFarms().add(turRect);
            root.getChildren().add(turRect);
            levelCommands.getFarms().add(turRect);
        }
    }





    public AnchorPane getRoot() {
        return root;
    }



    public void transportClicked(MouseEvent mouseEvent) throws IOException {
        Scene loginScene= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/Storage.fxml")));
        stage.setScene(loginScene);
        stage.show();
    }

    private LevelCommands levelCommands ;

    public void setLevelCommands(LevelCommands levelCommands) {
        this.levelCommands = levelCommands;
    }

    public void setCoinsLabel(){
        coinsLabel.setText(String.valueOf(Main.currentPlayer.getCoin()));
    }

    public void dryEggClicked(MouseEvent mouseEvent) {
    }

    public void bakeryClicked(MouseEvent mouseEvent) {
    }

    public void makeHenClicked(MouseEvent mouseEvent) {
        MyStore store = levelCommands.getStore() ;
        if(store.getEggNumber() > 0){
            Timer timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> makeHen(store));
                    timer.cancel();
                }
            };
            timer.schedule(timerTask,2000,1);
        }
    }

    private void makeHen(MyStore store){
        Music.playAction(Music.HEN);
        store.setEggNumber(store.getEggNumber() - 1);
        HenRect henRect = new HenRect(87,1,levelCommands);
        root.getChildren().add(henRect);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        MainGround.stage = stage;
    }

}