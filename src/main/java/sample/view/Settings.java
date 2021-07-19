package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sample.Main;

import java.io.File;
import java.io.IOException;

public class Settings {
    public void AboutUsButtonClicked(MouseEvent mouseEvent) throws IOException {
        Scene welcomeMenu= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/AboutUs.fxml")));
        Main.stage.setScene(welcomeMenu);
    }

    public void MusicButtonClicked(MouseEvent mouseEvent) {
        String musicFile = "02 viola.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
        Scene welcomeMenu= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/MainMenu.fxml")));
        Main.stage.setScene(welcomeMenu);
    }
}
