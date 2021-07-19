
package sample.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import sample.Main;

import java.io.IOException;

public class MidMenu {
    public void resumeButtonClicked(MouseEvent mouseEvent) {
        //TODO
    }

    public void exitButtonClicked(MouseEvent mouseEvent) throws IOException {
        Scene welcomeMenu= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/MainMenu.fxml")));
        Main.stage.setScene(welcomeMenu);
    }
}