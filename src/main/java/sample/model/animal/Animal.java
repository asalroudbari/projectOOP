package sample.model.animal;

import sample.controller.task.concrete.GeneralMovement.Record;
import sample.model.Ground;
import sample.util.RandomUtil;

import java.util.ArrayList;

public abstract class Animal {
    public static ArrayList<Animal> animals = new ArrayList<>();

    protected int x;
    protected int y;
    protected int health = 100;

    public Animal(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void eat() {
        if(Ground.ground[x][y].equals(Ground.GRASS)) {
            Ground.ground[x][y] = null;
        }
    }

    public void decreaseHealth() {
        this.health -= 10;
    }

    public void increaseHealth() {
        this.health += 10;
    }

    public void generateRandomMove(Record record) {
        int step = RandomUtil.randomStep();
        String direction = RandomUtil.randomDirection();
        Ground.ground[x][y] = " ";
        if (direction.equals("X")) {
            x += step;
            if (x < 0) x = 0;
            if (x > 5) x = 5;
        } else {
            y += step;
            if (y < 0) y = 0;
            if (y > 5) y = 5;
        }

        record.nextCell.setXY(x, y);
    }

    public void move(int x, int y) {
        Ground.ground[x][y] = this.toString();
    }

    public void setRecordInfo(Record record) {
        record.curCell.setXY(this.x, this.y);
        generateRandomMove(record);
    }

    public int getHealth() {
        return health;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public static void decreaseAnimalsHealth() {
        for (Animal animal: animals) {
            if(animal.health == 0) animals.remove(animal); // removes an animal if the health becomes 0
            animal.health -= 10;
        }
    }
}