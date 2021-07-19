package sample.model;

import sample.controller.task.TaskExecutor;
import sample.controller.task.concrete.WellTask;


// well
public class Irrigation {
    private static int wellCounter; // number of times bucket was used

    public static void tryWell() {
        if(bucketIsEmpty()) {
            TaskExecutor.addTask(new WellTask());
        } else {
            System.out.println("Bucket isn't empty yet!");
        }
    }

    public static void well() {
        wellCounter = 5;
    }

    public static void useWater() {
        wellCounter--;
    }

    public static boolean bucketIsEmpty() {
        return wellCounter == 0;
    }
}
