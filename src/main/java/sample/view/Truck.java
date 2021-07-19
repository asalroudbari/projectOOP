package sample.view;

import sample.model.animal.Animal;
import sample.model.product.Product;

import java.util.ArrayList;

public class Truck {
    public final int MAXCAPACITY = 15;
    public int usedCapacity = 0;
    int timeToFinish = 10;
    boolean isAvailable = true;
    public int totalCost = 0;
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Animal> animals = new ArrayList<>();

    public int UsedCapacity() {
        for(Product p : products) {
            usedCapacity += p.getCapacity();
        }
        for (Animal a : animals) {
//            usedCapacity += a.getCapacity();
        }
        return usedCapacity;
    }

    public boolean isAvailable() {
        isAvailable = isAvailable && usedCapacity <= MAXCAPACITY;
        return isAvailable;
    }
    public int totalCost() {
        for(Product p : products){
            totalCost+= p.getPrice();
        }
        for (Animal a : animals){
//            totalCost += a.getPrice();
        }
        return totalCost;
    }

    public void run() {
//        totalMoney += totalCost(); // will be defined somewhere else
        usedCapacity = 0;
        products.clear();
        animals.clear();
    }
}
