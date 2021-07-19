package sample.controller;

import java.sql.*;
import java.util.ArrayList;

public abstract class DatabaseController {

    static Connection connection ;

    static Statement statement;

    public static void createConnection(){
        try {
            //Class.forName("com.mysql.jdbc.Driver");   //Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmfrenzy"
                    ,"asal","asal7114");
            statement = connection.createStatement();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }  // worked properly

    public static void closeConnection(){
        if(connection != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }  // worked properly

    public static boolean canCreatePlayer(Player player){
        createConnection();
        ResultSet resultSet = null;
        boolean can = true ;
        try {
            resultSet = statement.executeQuery(String.format("SELECT * FROM PLAYERS WHERE IDPLAYERS = '%s'"
                    ,player.getUserName()));
            can = ! resultSet.next();
            closeConnection();  //  ** we can not close at first then use resultSet
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return can;
    }  // worked properly

    public static ArrayList<Player> getPlayersArray(){
        ArrayList<Player>players;
        players = new ArrayList<>();
        createConnection();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PLAYERS");
            while (resultSet.next()){
                players.add(new Player(resultSet.getString(1),resultSet.getString(2),
                        resultSet.getInt(3),resultSet.getInt(4)));
            }
            closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return players ;
    }  // worked properly

    public static void update(ArrayList<Player>players){
        for (Player player : players) {
            createConnection();
            try {
                statement.execute(String.format("UPDATE PLAYERS SET COINS = '%d' , LEVEL ='%d' WHERE IDPLAYERS = '%s'",
                        player.getCoin(),player.getLevel(),player.getUserName()));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        closeConnection();
    }  // worked properly

    public static void addPlayer(Player player){
        createConnection();
        try {
            statement.execute(String.format("INSERT INTO PLAYERS VALUES ('%s' , '%s' , 500 , 1)",player.getUserName(),
                    player.getPassword()));
            closeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }  // worked properly
    public static boolean checkPassword (String username, String password){
        ArrayList<Player> players = getPlayersArray();
        for (Player player : players) {
            if(player.getUserName().equals(username)){
                if (player.getPassword().equals(password)){
                    return true;
                }
            }
        }
        return false;
    }
}