package sample.model;

public enum Products {
    
    HEN_EGG(15,15),
    
    WOOL(30,70),
    
    TUR_FEATHER(15,30),
    
    FLOUR(15,40),
    
    BREAD(35,50);
    

    public final  int capacity;

    public final  int price;

    Products(int capacity,int price){
        this.capacity = capacity;
        this.price = price ;
    }
}
