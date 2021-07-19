package sample.model;

public class MyStore {
    public static int CAPACITY_STORE = 150 ;

    private int currentCapacity = 0 ;

    public static int HELI_CAPACITY = 50 ;

    private int woolNumber = 0;

    private int eggNumber = 0;

    private int featherNumber = 0;

    private int breadNumber = 0;

    private int flourNumber = 0;

    private int lionNumber = 0;

    private int tigerNumber = 0;

    private int bearNumber = 0;

    private int henNumber = 0;

    private int bufNumber = 0;

    private int turNumber = 0;

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getWoolNumber() {
        return woolNumber;
    }

    public void setWoolNumber(int woolNumber) {
        this.woolNumber = woolNumber;
    }

    public int getEggNumber() {
        return eggNumber;
    }

    public void setEggNumber(int eggNumber) {
        this.eggNumber = eggNumber;
    }

    public int getFeatherNumber() {
        return featherNumber;
    }

    public void setFeatherNumber(int featherNumber) {
        this.featherNumber = featherNumber;
    }

    public int getBreadNumber() {
        return breadNumber;
    }

    public void setBreadNumber(int breadNumber) {
        this.breadNumber = breadNumber;
    }

    public int getFlourNumber() {
        return flourNumber;
    }

    public void setFlourNumber(int flourNumber) {
        this.flourNumber = flourNumber;
    }

    public int getLionNumber() {
        return lionNumber;
    }

    public void setLionNumber(int lionNumber) {
        this.lionNumber = lionNumber;
    }

    public int getTigerNumber() {
        return tigerNumber;
    }

    public void setTigerNumber(int tigerNumber) {
        this.tigerNumber = tigerNumber;
    }

    public int getBearNumber() {
        return bearNumber;
    }

    public void setBearNumber(int bearNumber) {
        this.bearNumber = bearNumber;
    }

    public int getHenNumber() {
        return henNumber;
    }

    public void setHenNumber(int henNumber) {
        this.henNumber = henNumber;
    }

    public int getBufNumber() {
        return bufNumber;
    }

    public void setBufNumber(int bufNumber) {
        this.bufNumber = bufNumber;
    }

    public int getTurNumber() {
        return turNumber;
    }

    public void setTurNumber(int turNumber) {
        this.turNumber = turNumber;
    }

    public boolean canAdd(int temp){
        return (CAPACITY_STORE >= temp + currentCapacity);
    }

    public void addToStore (int temp){
        currentCapacity+=temp;
    }
}
