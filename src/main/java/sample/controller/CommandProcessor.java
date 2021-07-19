package sample.controller;

import java.util.Scanner;

public class CommandProcessor {
    private enum State {SIGNUP, LOGIN};
    private State state;

    protected static final String EXIT = "EXIT";
    protected static boolean exitReq = false;


    private final String START = "LEVEL.*";
    private final String LOGOUT = "LOG OUT.*";
    private final String SETTINGS = "SETTINGS";


    public static void startCommandProcess() {
        Scanner scanner = new Scanner(System.in);
        EntryHandler.prepareEntrance(scanner); // currentUser is not null now
        if(exitReq) return;

        GameCommandsHandler.startGame(scanner);

//        String command;
//        while(!(command = scanner.nextLine()).equals(EXIT)) {
//            processCommand(scanner.nextLine(), scanner);
//        }
        scanner.close();
    }



}
