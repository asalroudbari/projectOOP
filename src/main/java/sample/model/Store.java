package sample.model;

import java.util.ArrayList;

public class Store {

    private static ArrayList<Storable> items = new ArrayList<>();
    private static final int maxCapacity = 30;
    private static int capacity = 0;

    public static boolean store(Storable item) {
        if (item.getCapacity()+capacity > maxCapacity)
            return false;
        else {
            items.add(item);
            capacity += item.getCapacity();
            return true;
        }
    }

    public static Storable remove(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            Storable item = items.get(i);
            if (item.getName().equals(itemName)){
                capacity -= item.getCapacity();
                return items.remove(i);
            }
        }
        return null;
    }
}
