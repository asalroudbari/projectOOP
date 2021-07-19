package sample.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PreGame implements Initializable {
    private static int currentLevel;
    private static Image lock = new Image(String.valueOf(PreGame.class.
            getResource("/Images/lock.png" )));
    @FXML
    private GridPane levels;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        levels.getColumnConstraints().clear();
        for(int i = 0  ; i < 5; i ++){
            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(150);
            rectangle.setHeight(150);
            rectangle.setArcWidth(30);
            rectangle.setArcHeight(30);
            int x = i;
            rectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    // int column = GridPane.getColumnIndex(rectangle);
                    if((x+1) > Main.currentPlayer.getLevel()){
                        new Alert(Alert.AlertType.ERROR,"this leve is locked for you :)").show();
                    }
                    else {
                        switch (x+1){
                            case 1 :
                                try {
                                    Scene map = new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/Level1.fxml")));
                                    Main.stage.setScene(map);
                                    Main.stage.show();
                                    setCurrentLevel(1);

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2 :
                                try {
                                    Scene map = new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/Level2.fxml")));
                                    Main.stage.setScene(map);
                                    Main.stage.show();
                                    setCurrentLevel(2);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3 :
                                try {
                                    Scene map = new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/Level3.fxml")));
                                    Main.stage.setScene(map);
                                    Main.stage.show();
                                    setCurrentLevel(3);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            default:

                        }
                    }
                }});
            if((i+1)<= Main.currentPlayer.getLevel())
            {
                rectangle.setStyle("-fx-fill: "
                        + "linear-gradient(#ffd65b, #e68400),"
                        + "linear-gradient(#ffef84, #f2ba44),"
                        + "linear-gradient(#ffea6a, #efaa22),"
                        + "linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),"
                        + "linear-gradient(from 0% 0% to 15% 50%, "
                        + "rgba(255,255,255,0.9), rgba(255,255,255,0));");
                Text text = new Text((i+1)+"");
                text.setFont(new Font("Verdana Bold", 50));
                text.setEffect(new Reflection());
                StackPane stackPane = new StackPane();
                stackPane.setPrefHeight(200);
                stackPane.setPrefWidth(200);
                stackPane.getChildren().addAll(rectangle, text);
                levels.add(stackPane ,i, 0);
            }else {
                rectangle.setFill(new ImagePattern(lock));
                levels.add( rectangle,i, 0);
            }
        }

    }
    public void backButton(MouseEvent mouseEvent) throws IOException {
        Scene mainMenu = new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/MainMenu.fxml")));
        Main.stage.setScene(mainMenu);
    }

    public static int getCurrentLevel(){
        return currentLevel;
    }
    public static void setCurrentLevel(int level){
        currentLevel= level;
    }
}
