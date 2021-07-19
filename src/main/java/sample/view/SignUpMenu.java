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

public class SignUpMenu {
    private static SignUpMenu signUpMenu;
    @FXML
    private TextField passwordField;
    @FXML
    private   TextField usernameField;
    public static SignUpMenu getInstance() {
        if (signUpMenu == null)
            signUpMenu= new SignUpMenu();
        return signUpMenu;
    }

    public void signupButtonClicked(MouseEvent mouseEvent) throws IOException {
        if(usernameField.getText().equals("") || passwordField.getText().equals(""))
            new Alert(Alert.AlertType.ERROR,"please complete information").show();
        else {
            EntryHandler.EntryErrors entryErrors = EntryHandler.signUp(usernameField.getText(),passwordField.getText());
            if(entryErrors.equals(EntryHandler.EntryErrors.USERNAME_ALREADY_EXISTS)) {
                new Alert(Alert.AlertType.ERROR, "this username already exists").show();
                Scene mainMenu = new Scene(FXMLLoader.load(getClass().getResource("/FxmlFiles/Welcome.fxml")));
                Main.stage.setScene(mainMenu);
            }
            else if(entryErrors.equals( EntryHandler.EntryErrors.SIGNUP_SUCCESSFULLY)){
                new Alert(Alert.AlertType.INFORMATION,"you signed up successfully!").show();
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
