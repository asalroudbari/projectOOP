package sample.controller;

import sample.controller.task.concrete.*;
import sample.model.Ground;
import sample.model.Irrigation;
import sample.model.Payable;
import sample.model.TruckAgent;
import sample.model.animal.Animal;
import sample.model.animal.concrete.*;
import sample.controller.task.Processable;
import sample.controller.task.TaskExecutor;

import java.util.Scanner;

import static sample.controller.CommandProcessor.EXIT;
import static sample.Main.currentUser;
import static sample.model.animal.Animal.animals;

public class GameCommandsHandler {

    // commands
    private final static String START_COMMAND = "START.*";
    private final static String BUY_COMMAND = "BUY.*"; //handled
    private final static String PICKUP_COMMAND = "PICKUP.*";
    private final static String WELL_COMMAND = "WELL.*"; //handled
    private final static String PLANT_COMMAND = "PLANT.*";
    private final static String WORK_COMMAND = "WORK.*";
    private final static String CAGE_COMMAND = "CAGE.*";
    private final static String TURN_COMMAND = "TURN.*";
    private final static String TRUCK_LOAD_COMMAND = "TRUCK LOAD.*";
    private final static String TRUCK_UNLOAD_COMMAND = "TRUCK UNLOAD.*";
    private final static String TRUCK_GO_COMMAND = "TRUCK GO.*";


    public static void startGame(Scanner scanner) {
        String command;
        while(!(command = scanner.nextLine()).equals(EXIT)) {
            processCommand(command, scanner);
        }
    }

    private static void processCommand(String command, Scanner scanner) {
        if(command.matches(START_COMMAND)) {
//            handleLevel();
        } else if(command.matches(BUY_COMMAND)) {
            buy(command);
        } else if(command.matches(PICKUP_COMMAND)) {
            pickup(command);
        } else if(command.matches(WELL_COMMAND)) {
            well();
        } else if(command.matches(PLANT_COMMAND)) {
            plant(command);
        } else if(command.matches(WORK_COMMAND)) {
            work(command);
        } else if(command.matches(TURN_COMMAND)) {
            turn(command);
        } else if(command.matches(TRUCK_LOAD_COMMAND)) {
            truck_load(command);
        } else if(command.matches(TRUCK_UNLOAD_COMMAND)) {
            truck_offLoad(command);
        } else if(command.matches(TRUCK_GO_COMMAND)) {
            truck_go();
        }
    }

    private static void truck_go() {
        TruckAgent.sendTruck();
    }

    private static void truck_offLoad(String command) {
        String[] args = command.split(" ");
        TruckAgent.tryOffLoad(args[1]);
    }

    private static void truck_load(String command) {
        String[] args = command.split(" ");
        TruckAgent.loadTruck(args[1]);
    }

    private static void turn(String command) {
        int turn = Integer.parseInt(command.split(" ")[1]);
        TaskExecutor.startTurn(turn);
    }


//    private static void handleLevel() {
//        // TODO level should set
//    }


    private static void buy(String command) {
        String animal = command.split(" ")[1];
        Payable payable;
        switch (animal) {
            case "CHICKEN": payable = new Chicken(0, 0); break;
            case "TURKEY": payable = new Turkey(0, 0); break;
            case "BUFFALO": payable = new Buffalo(0, 0); break;
            case "DOG": payable = new Dog(0, 0); break;
            case "CAT": payable = new Cat(0, 0); break;
            default:
                System.out.println("This animal can't be bought");
                return;
        }
        if(currentUser.canAfford(payable)) {
            animals.add((Animal)payable);
            System.out.println("Animal bought successfully");
        } else {
            System.out.println("Not enough money");
        }
    }

    private static void pickup(String command) {
        String split[] = command.split(" ");
        TaskExecutor.addTask(new PickUpTask(Integer.parseInt(split[1]),
                Integer.parseInt(split[2])));
    }

    private static void well() {
        Irrigation.tryWell();
    }

    private static void plant(String command) {
        String split[] = command.split(" ");
        TaskExecutor.addTask(new PlantTask(Integer.parseInt(split[1]),
                Integer.parseInt(split[2])));
    }


    private static final String MILL = "mill.*";
    private static final String CLOTHFACTORY = "cloth.*";
    private static final String MILKPACKETINGFACTORY = "milk.*";
    private static final String BAKERY = "bakery.*";
    private static final String SEWINGFACTORY = "sewing.*";
    private static final String ICECREAMFACTORY = "ice.*";

    public static void work(String command) {
        String facName = command.split(" ")[1];
        Processable processable = null;
        switch (facName) {
            case MILL:
                processable = new MillTask();
                break;

            case CLOTHFACTORY:
                processable = new ClothFactoryTask();
                break;

            case MILKPACKETINGFACTORY:
                processable = new MilkPacketingTask();
                break;

            case BAKERY:
                processable = new BakeryTask();
                break;

            case SEWINGFACTORY:
                processable = new SewingFactoryTask();
                break;

            case ICECREAMFACTORY:
                processable = new IceCreamFactoryTask();
                break;

            default:
                System.out.println("No such factory");
                return;
        }
        TaskExecutor.addTask(processable);
    }
}
