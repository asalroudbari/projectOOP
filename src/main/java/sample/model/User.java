package sample.model;

import java.util.ArrayList;

public class User {
    public static ArrayList<User> users = new ArrayList<>();
    private String username;
    private String password;
    private int money = 500;
    private int level = 1;

    public static void registerUser(String username, String password) {
        new User(username, password);
    }

    private User(String username, String password) {
        this.username = username;
        this.password = password;
        users.add(this);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void setUsers(ArrayList<User> users) {
        User.users = users;
    }

    public boolean canAfford(Payable payable) {
        if(money >= payable.getPrice()) {
            money -= payable.getPrice();
            return true;
        }
        return false;
    }

    public static User getUser(String username) {
        for (User user: users) {
            if(user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static void findUser() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
