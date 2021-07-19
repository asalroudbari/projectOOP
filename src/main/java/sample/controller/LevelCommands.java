package sample.controller;

import sample.Main;
import sample.model.MyStore;
import sample.model.Products;
import sample.model.WildType;
import sample.model.animal.Animal;
import sample.model.animal.Domestic;
import sample.model.animal.Helping;
import sample.model.animal.Wild;
import sample.model.factory.Factory;
import sample.model.product.Product;
import sample.view.AnimalsRect.FarmAnimalRect;
import sample.view.AnimalsRect.HelpingRect;
import sample.view.AnimalsRect.WildRect;
import sample.view.GrassRect;
import sample.view.MainGround;
import sample.view.PreGame;
import sample.view.ProductRect.ProductRect;

import java.util.ArrayList;
import java.util.WeakHashMap;

public class LevelCommands {
    public void setMainGround(MainGround mainGround) {
        this.mainGround = mainGround;
    }

    private MyStore store;

    public MyStore getStore() {
        return store;
    }

    private MainGround mainGround;
    private ArrayList<FarmAnimalRect> farms;

    private ArrayList<ProductRect> products ;

    private ArrayList<HelpingRect> helpings ;
    private ArrayList<WildRect> wilds;
    private Player player ;

    public MainGround getMainGround() {
        return mainGround;
    }


    public Player getPlayer() {
        return player;
    }


    public ArrayList<Factory> getFactories() {
        return factories;
    }

    public int getLevel() {
        return level;
    }

    private ArrayList<Factory> factories ;

    private int level ;

    public LevelCommands() {
        init();
        this.player = Main.currentPlayer;
        this.level = PreGame.getCurrentLevel();
    }

    private void init(){
        store = new MyStore();
        farms = new ArrayList<>();
        products = new ArrayList<>();
        helpings = new ArrayList<>();
        wilds = new ArrayList<>();
        factories = new ArrayList<>();
        grassRects = new ArrayList<>();
    }
    public ArrayList<FarmAnimalRect> getFarms() {
        return farms;
    }

    public ArrayList<ProductRect> getProducts() {
        return products;
    }

    public ArrayList<HelpingRect> getHelpings() {
        return helpings;
    }

    public ArrayList<WildRect> getWilds() {
        return wilds;
    }

    private ArrayList<GrassRect> grassRects ;

    public ArrayList<GrassRect> getGrassRects() {
        return grassRects;
    }

    public void buyFarm(FarmAnimalRect domestic){
        farms.add(domestic);
    }


    public void buyHelping(HelpingRect helping){
        helpings.add(helping);
    }

    public void removeFarmAnimal(FarmAnimalRect farmAnimalRect){
        try{
            farmAnimalRect.getAnimation().stop();
            System.out.println(farmAnimalRect);
            farms.remove(farmAnimalRect);
            mainGround.getRoot().getChildren().remove(farmAnimalRect);
        }catch (NullPointerException e){

        }
    }

    public void captureWildAnimal(WildRect wildRect){
        if(wildRect.isHarming()){
         wildRect.goToCage();
        }
    }

    public void captureProduct(ProductRect productRect) {
        if (store.canAdd(productRect.getProduct().capacity)) {
            try {
                products.remove(productRect);
            } catch (NullPointerException e) {

            }
            switch (productRect.getProduct()){
                case WOOL :
                    store.setWoolNumber(store.getWoolNumber()+1);
                    store.addToStore(Products.WOOL.capacity);
                    break;
                case HEN_EGG:
                    store.setEggNumber(store.getEggNumber()+1);
                    store.addToStore(Products.HEN_EGG.capacity);
                    break;
                case TUR_FEATHER:
                    store.setFeatherNumber(store.getFeatherNumber()+1);
                    break;
            }
        }
    }
}
