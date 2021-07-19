package sample.controller.task;

import sample.controller.task.concrete.GeneralMovement;
import sample.model.Ground;
import sample.model.animal.Animal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TaskExecutor {
    private static Queue<Processable> tasks = new LinkedList<>();
    private static ArrayList<Processable> inProcessTasks = new ArrayList<>();
    private static GeneralMovement generalMovement = new GeneralMovement();

    public static void startTurn(int turn) {
        for (int i = 0; i < turn; i++) {
            Animal.decreaseAnimalsHealth();

            scheduleTasks();

            generalMovement.process();
        }
        Ground.print();
    }

    private static void scheduleTasks() {
        Processable poll = tasks.poll();
        if (poll != null) inProcessTasks.add(poll);

        for (int j = 0; j < inProcessTasks.size(); j++) {
            Processable processable = inProcessTasks.get(j);
            if (processable.process()) {
                inProcessTasks.remove(processable);
            }
        }
    }

    public static void addTask(Processable processable) {
        tasks.add(processable);
    }
}
