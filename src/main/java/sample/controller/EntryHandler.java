package sample.controller;

import javafx.css.converter.LadderConverter;
import sample.model.User;

import java.util.Scanner;

import static sample.Main.currentPlayer;
import static sample.controller.CommandProcessor.exitReq;
import static sample.Main.currentUser;
import static sample.model.User.*;

/* for signup, username shouldn't be taken before
*   if it was taken, process should start from top
*   if it wasn't taken, a password is set and User is added to users list */

/* for login, username should be on the list
* if it wasn't, process should start from top
* if it was, entered password should match the username password in the users list */

/* if none of the above was successful or exit request was demanded, USER field remains null */

public class EntryHandler {
    private final static String USERNAME_COMMAND = "USERNAME.*";
    private final static String PASSWORD_COMMAND = "PASSWORD.*";
    private final static String LOGIN_COMMAND = "LOG IN";
    private final static String SIGNUP_COMMAND = "SIGNUP";

    private static
    boolean hadLoggedIn;

    private EntryHandler() {
    }

    public enum EntryErrors {
        USERNAME_DOESNT_EXISTS,
        LOGGED_IN_SUCCESSFULLY,
        USERNAME_ALREADY_EXISTS,
        SIGNUP_SUCCESSFULLY,
        WRONG_PASSWORD;
    }


    public static void prepareEntrance(Scanner scanner) {
        getCommand(scanner);
    }

    private static void getCommand(Scanner scanner) {
        while (currentUser == null && !exitReq && !hadLoggedIn) {
            processCommand(scanner.nextLine(), scanner);
        }
    }

    public static void processCommand(String command, Scanner scanner) {
        if (command.matches(CommandProcessor.EXIT)) {
            exitReq = true;
        } else if (command.matches(SIGNUP_COMMAND)) {
//            state = CommandProcessor.State.SIGNUP;
            System.out.println("Your username and password please");
            handleSignUp(scanner);
        } else if (command.matches(LOGIN_COMMAND)) {
//            state = CommandProcessor.State.LOGIN;
            handleLogin(scanner);
        }
    }


    private static void handleSignUp(Scanner scanner) {
        String command = scanner.nextLine();
        if (!command.matches(USERNAME_COMMAND)) System.out.println("Wrong command");

        String username = command.split(" ")[1];

        if (getUser(username) != null) {
            System.out.println("Username already taken");
            // TODO try again
        } else {
            System.out.println("Set password");
        }


        command = scanner.nextLine();
        String password = command.split(" ")[1];

        registerUser(username, password);

        System.out.println("user registered successfully");
        hadLoggedIn = true;
        currentUser = users.get(users.size() - 1);
    }
    public static EntryErrors signUp(String username, String password) {
       /*DatabaseController.getInstance().refreshUsersFromFileJson();
        if (getUser(username) != null)
           return EntryErrors.USERNAME_ALREADY_EXISTS;
        registerUser(username, password);
        hadLoggedIn = true;
        currentUser = users.get(users.size() - 1);
       // DatabaseController.getInstance().refreshUsersToFileJson();
        return EntryErrors.SIGNUP_SUCCESSFULLY;*/
        Player player = new Player(username , password);
        boolean canCreate = DatabaseController.canCreatePlayer(player);
        if (canCreate){
            DatabaseController.addPlayer(player);
            currentPlayer = player;
            return EntryErrors.SIGNUP_SUCCESSFULLY;
        }
        return EntryErrors.USERNAME_ALREADY_EXISTS;
    }

    public static EntryErrors login(String username, String password) {
        /*//DatabaseController.getInstance().refreshUsersFromFileJson();
        User user = getUser(username);
        if (user == null)
            return  EntryErrors.USERNAME_DOESNT_EXISTS;
        if (!user.getPassword().equals(password)) {
            return EntryErrors.WRONG_PASSWORD;
        }
        currentUser = user;
        hadLoggedIn = true;
        return EntryErrors.LOGGED_IN_SUCCESSFULLY;*/
        Player player = new Player(username , password);
        boolean canCreate = DatabaseController.canCreatePlayer(player);
        if(!canCreate){
            boolean check = DatabaseController.checkPassword(username , password);
            if(check){
                currentPlayer = player;
                return EntryErrors.LOGGED_IN_SUCCESSFULLY;
            }
            else{
                return EntryErrors.WRONG_PASSWORD;
            }
        }
        else{
            return  EntryErrors.USERNAME_DOESNT_EXISTS;
        }
    }



    private static void handleLogin(Scanner scanner) {
        String command = scanner.nextLine();
        if(!command.matches(USERNAME_COMMAND)) System.out.println("Wrong command");

        String username = command.split(" ")[1];

        User user = getUser(username);
        if(user == null) {
            System.out.println("No such username");
            return;
        } else {
            System.out.println("password?");
        }

        command = scanner.nextLine();
        String password = command.split(" ")[1];

        if(!user.getPassword().equals(password)) {
            System.out.println("Wrong password");
            return;
        }

        System.out.println(users);
        //TODO get user info from file
        currentUser = user;
        hadLoggedIn = true;
    }
}
