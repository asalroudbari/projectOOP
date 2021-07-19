package sample.controller;

public class Player {
    private String userName;
    private String password;
    private int level = 1;
    private int coin = 500;

    public Player(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public Player(String userName, String password, int level, int coin) {
        this.userName = userName;
        this.password = password;
        this.level = level;
        this.coin = coin;
    }
}