package sample.controller.task.concrete;

import sample.controller.task.Processable;
import sample.model.Ground.Cell;
import sample.model.animal.Animal;
import sample.model.animal.Domestic;
import sample.model.animal.Helping;
import sample.model.animal.Wild;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static sample.model.animal.Animal.*;

public class GeneralMovement implements Processable {

    public class Record {
        public Animal animal;
        public Cell curCell;
        public Cell nextCell;

        @Override
        public boolean equals(Object obj) {
            return ((Record) obj).nextCell == this.nextCell;
        }
    }

    private ArrayList<Record> records = new ArrayList<>();

    @Override
    public boolean process() {
        predictMoves();
        decideMoves(); // animals are settled here
        return true;
    }

    // We know the current position & the next random position for each animal
    private void predictMoves() {
        Record record;
        for (Animal animal: animals) {
            record = new Record();
            record.animal = animal;
            animal.setRecordInfo(record);
            records.add(record);
        }
    }

    // it'll find Records with equal nextCells
    // store them in conflicts array and handle it.
    private void decideMoves() {
        for (Record curRecord : records) {
            ArrayList<Record> conflicts = new ArrayList<>();
            conflicts.add(curRecord);

            for (Record otherRecord: records) {
                if(curRecord.nextCell.equals(otherRecord.nextCell)) {
                    conflicts.add(otherRecord);
                    records.remove(otherRecord);
                }
            }

            records.remove(curRecord);
            handleConflicts(conflicts); // new positions are settled now
        }
    }



    public static Comparator<Record> HealthComparator = new Comparator<Record>() {

        public int compare(Record rec1, Record rec2) {
            int health1 = rec1.animal.getHealth();
            int health2 = rec2.animal.getHealth();

            return health1 - health2;
        }
    };


    private void handleConflicts(ArrayList<Record> conflicts) { // they have collided
        Collections.sort(conflicts, HealthComparator); // ascending
        Record record = null;
        for (int i = 0; i < conflicts.size(); i++) {
            if(conflicts.get(i).animal instanceof Domestic) { // first index has got the lowest health
                record = conflicts.get(i);
                break;
            }
        }
        int targetX = record.nextCell.x;
        int targetY = record.nextCell.y;
        record.animal.setX(targetX);
        record.animal.setY(targetY); // lowest health animal goes in (x, y)

        for (Record rec: records) { // if there was a wild animal and a conflict, the record with lowest health will die,
            // and the wild animal replaces
            if (rec.animal instanceof Wild) {
                Wild wild = (Wild) rec.animal;
                for(Record re: records) {
                    if (re.animal instanceof Helping) {
                        Helping helping = (Helping) re.animal;
                        helping.killSelfAndWild(wild);
                        return;
                    }
                }
                wild.kill(record.animal, targetX, targetY);
            }
        }
    }
}
