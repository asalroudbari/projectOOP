package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.controller.Player;
import sample.model.User;

import java.io.IOException;

import static sample.controller.CommandProcessor.startCommandProcess;

public class Main  extends Application {
    public static Stage stage;
    public static User currentUser;
    public static Player currentPlayer;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("/FxmlFiles/Welcome.fxml"));
        stage.setScene(new Scene(root));
        stage.setMaximized(true);
        stage.show();
    }
    public void loginButtonClicked(MouseEvent mouseEvent)throws IOException {
        Scene loginScene= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/Login.fxml")));
        stage.setScene(loginScene);
    }
    public void signUpButtonClicked(MouseEvent mouseEvent) throws IOException{
        Scene signUpScene= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/Signup.fxml")));
        stage.setScene(signUpScene);
    }
    public void exitButtonClicked(MouseEvent mouseEvent) throws IOException{
        System.exit(0);
    }

    public void resumeButtonClicked(MouseEvent mouseEvent) {
        //TODO
    }
    public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
        Scene welcomeMenu= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/MainMenu.fxml")));
        Main.stage.setScene(welcomeMenu);
    }
    public void OkButtonClicked(MouseEvent mouseEvent) throws IOException {
        Scene map = new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/MainGround.fxml")));
        Main.stage.setScene(map);
        Main.stage.show();
    }

    public void music1ButtonClicked(MouseEvent mouseEvent) {
        
    }

    public void music2ButtonClicked(MouseEvent mouseEvent) {
    }
}
