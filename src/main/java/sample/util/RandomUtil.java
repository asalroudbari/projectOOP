package sample.util;

import java.util.Random;

public class RandomUtil {
    public static int randomStep() {
        int pivot = new Random(System.currentTimeMillis()).nextInt(10);
        if (pivot > 5)
            return 1;
        else return -1;
    }
    public static String randomDirection() {
        int pivot = new Random(System.currentTimeMillis()).nextInt(10);
        if (pivot > 5)
            return "X";
        else return "Y";
    }
}
