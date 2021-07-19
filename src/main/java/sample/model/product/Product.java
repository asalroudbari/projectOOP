package sample.model.product;

import sample.model.Storable;

import java.util.ArrayList;

public abstract class Product implements Storable {
    public static ArrayList<Product> products = new ArrayList<>();

    protected int price;
    protected int capacity;

    public Product(int price, int capacity) {
        this.price = price;
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    protected abstract boolean isAvailable();
}
