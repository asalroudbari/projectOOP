package sample.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.Main;
import sample.controller.EntryHandler;

import java.io.IOException;

public class LoginMenu {
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField usernameTextField;

    public void submitButtonClicked(MouseEvent mouseEvent) throws IOException {
        if(usernameTextField.getText().equals("") || passwordTextField.getText().equals(""))
            new Alert(Alert.AlertType.ERROR,"please complete information").show();
        else {
            EntryHandler.EntryErrors entryErrors = EntryHandler.login(usernameTextField.getText(),passwordTextField.getText());
            if(entryErrors.equals(EntryHandler.EntryErrors.USERNAME_DOESNT_EXISTS))
                new Alert(Alert.AlertType.ERROR,"this username doesn't exist").show();
            if(entryErrors.equals(EntryHandler.EntryErrors.WRONG_PASSWORD))
                new Alert(Alert.AlertType.ERROR,"wrong password! please try again!").show();
            else if(entryErrors.equals( EntryHandler.EntryErrors.LOGGED_IN_SUCCESSFULLY)){
                new Alert(Alert.AlertType.INFORMATION,"you logged in successfully!").show();
                Scene mainMenu = new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/MainMenu.fxml")));
                Main.stage.setScene(mainMenu);
            }
        }
    }
    public void backButtonClicked(MouseEvent mouseEvent) throws IOException {
        Scene welcomeMenu= new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/Welcome.fxml")));
        Main.stage.setScene(welcomeMenu);

    }
}
