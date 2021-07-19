package sample.model;

import static sample.model.Irrigation.bucketIsEmpty;
import static sample.model.Irrigation.useWater;

public class Ground {
    public static String[][] ground = {
            {"0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0"}
    };
    public static String GRASS = "G";

    public class Cell {
        public int x;
        public int y;

        @Override
        public boolean equals(Object obj) {
            Cell otherCell = (Cell) obj;
            return (otherCell.x == this.x) &&
                    (otherCell.y == this.y);
        }

        public void setXY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static String pickup(int x, int y) {
        if(positionIsValid(x, y) && !ground[x][y].equals("0")) {
            return ground[x][y];
        } else {
            System.out.println("Either position is invalid or the cell is empty!");
        }
        return null;
    }

    private static boolean positionIsValid(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    public static void print() {
        for (String[] row : ground) {
            for (String tile : row) {
                System.out.print(tile + " ");
            }
            System.out.println();
        }
    }
}
