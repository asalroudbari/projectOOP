package sample.view;


import sample.Main;
import sample.controller.Player;

public class Levels {
    private final int level1_chick = 3;
    private final int level2_chick = 5;
    private final int level3_chick = 7;
    private final int level1_eggs = 10;
    private final int level1_coins= 300;
    private final int level2_eggs = 15;
    private final int level2_coins = 600;
    private final int level3_flours = 2;
    private final int level3_coins = 800;
    private final int level3_bread = 1;
    private final int level3_buffaloes = 2;
    private final int level2_buffaloes = 1;
    private final int level2_milks = 3;
    private final int level1_time = 120;
    private final int level2_time = 500;
    private final int level3_time = 900;



    public boolean checkLevel1(int chicks , int eggs , int coins , int time){
        if (chicks>= level1_chick && eggs>=level1_eggs && coins >=level1_coins && time <= level1_time){
            return true;
        }
        return false;
    }

    public boolean checkLevel2(int chicks , int eggs , int coins , int buffaloes , int milks , int time){
        if (chicks>= level2_chick && eggs>=level2_eggs && coins >=level2_coins && buffaloes >= level2_buffaloes && milks >= level2_milks && time <= level2_time){
            return true;
        }
        return false;
    }

    public boolean checkLevel3(int chicks , int flours , int coins , int buffaloes , int bread , int time ){
        if (chicks>= level3_chick && flours>=level3_flours && coins >=level3_coins && buffaloes >= level3_buffaloes && bread>= level3_bread && time <= level3_time){
            return true;
        }
        return false;
    }
    /*public void checker (int level){

        switch (level){
            case 1 :
                if (checkLevel1()){
                    Main.currentPlayer.setLevel(Main.currentPlayer.getLevel()++);
                }

        }
    }*/

}
