package sample.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.IOException;

public class Map {
    public void turkeyButtonClicked(MouseEvent mouseEvent) {

    }

    public void chickenButtonClicked(MouseEvent mouseEvent) {
    }

    public void buffaloButtonClicked(MouseEvent mouseEvent) {
    }

    public void wellButtonClicked(MouseEvent mouseEvent) {
    }

    public void truckButtonClicked(MouseEvent mouseEvent) {
    }

    public void menuButtonClicked(MouseEvent mouseEvent) throws IOException {
        Scene welcomeMenu= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/MidMenu.fxml")));
        Main.stage.setScene(welcomeMenu);
    }

    public void shopButtonClicked(MouseEvent mouseEvent) {
    }

    public void dogButtonClicked(MouseEvent mouseEvent) {
    }

    public void catButtonClicked(MouseEvent mouseEvent) {
    }
}
