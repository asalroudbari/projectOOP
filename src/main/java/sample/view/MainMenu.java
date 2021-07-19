package sample.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.IOException;
public class MainMenu {
    @FXML
    private TextField startTextField;
    @FXML
    private TextField settingsTextField;
    @FXML
    private TextField logOutTextField;

    public void  logOutButtonClicked (MouseEvent mouseEvent) throws IOException {
        Scene welcomeMenu= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/Welcome.fxml")));
        Main.stage.setScene(welcomeMenu);
    }
    public void startButtonClicked (MouseEvent mouseEvent) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/PreGame.fxml")));
        Main.stage.setScene(scene);
    }
    public void SettingsButtonClicked (MouseEvent mouseEvent) throws IOException{
        Scene welcomeMenu= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/Settings.fxml")));
        Main.stage.setScene(welcomeMenu);
    }
}