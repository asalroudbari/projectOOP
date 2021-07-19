package sample.util;

public abstract class MathUtil {
    public static double generateNumber(double min , double max){
        return Math.floor(Math.random()*(max-min+1)+min);
    }
}
