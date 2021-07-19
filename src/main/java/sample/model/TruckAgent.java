package sample.model;

import sample.controller.task.TaskExecutor;
import sample.controller.task.concrete.TruckLoadingTask;
import sample.controller.task.concrete.TruckOffLoadingTask;
import sample.controller.task.concrete.TruckTravelingTask;

import java.util.ArrayList;

public class TruckAgent {
    private static ArrayList<Storable> truck = new ArrayList<>();
    private static final int maxCapacity = 15;
    private static int capacity = 0;
    private static boolean isMoving = true;

    public static void tryLoad(String itemName) {
        if (isMoving)
            System.out.println("Truck is in move, it can not be loaded");
        TaskExecutor.addTask(new TruckLoadingTask(itemName));
    }

    public static void loadTruck(String itemName) {
        Storable item = Store.remove(itemName);
        if (item == null) return;

        if (item.getCapacity()+capacity > maxCapacity) {
           Store.store(item);
        } else {
            truck.add(item);
            capacity += item.getCapacity();
        }
    }

    public static void sendTruck() {
        isMoving = true;
        TaskExecutor.addTask(new TruckTravelingTask());
    }

    public static void stopTruck() {
        isMoving = false;
    }

    public static void tryOffLoad(String itemName) {
        if (isMoving)
            System.out.println("Truck is in move, it can not be offLoaded");
        TaskExecutor.addTask(new TruckOffLoadingTask(itemName));
    }

    public static void offLoad(String itemName) {
        for (int i = 0; i < truck.size(); i++) {
            Storable item = truck.get(i);
            if (item.getName().equals(itemName)){
                if (!Store.store(truck.remove(i))) {
                    truck.add(item);
                }
            }
        }
    }
}
