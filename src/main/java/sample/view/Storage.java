package sample.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import sample.Main;
import sample.controller.DatabaseController;
import sample.model.MyStore;
import sample.model.product.concrete.Egg;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Storage implements Initializable {
    int totalCost=0;
    @FXML
    private Button egg;
    @FXML
    private Button flour;
    @FXML
    private Button  feather;
    @FXML
    private Button milk;
    @FXML
    private Button bread;
    @FXML
    private Button cloth;
    @FXML
    private Button dress;
    @FXML
    private Button iceCream;
    @FXML
    private Button lion;
    @FXML
    private Button bear;
    @FXML
    private Button tiger;
    private HashMap<String , Integer> values ;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        values = new HashMap<>();
        values.put("egg",0);
        values.put("flour",0);
        values.put("feather",0);
        values.put("milk",0);
        values.put("bread",0);
        values.put("cloth",0);
        values.put("dress",0);
        values.put("iceCream",0);
        values.put("lion",0);
        values.put("bear",0);
        values.put("tiger",0);
    }
    public void calculateTotalCost(HashMap<String , Integer> values){
       totalCost = values.get("egg")*15 + values.get("feather")*20 + values.get("flour")*40 + values.get("milk")*25 + values.get("bread")*80
               + values.get("lion")*300 + values.get("bear")*400 +values.get("tiger") *500;
    }
        MyStore myStore = new MyStore();
  public void eggButton(javafx.scene.input.MouseEvent mouseEvent)
  {
      if(myStore.canAdd(1) ){
      int count =  values.get("egg");
      count++;
      egg.setText(count+"");
      values.put("egg",count);
      myStore.setCurrentCapacity(myStore.getCurrentCapacity()+1);
      }

  }
  public void flourButton(javafx.scene.input.MouseEvent mouseEvent)
  {
        if(myStore.canAdd(2)) {
            int count = values.get("flour");
            count++;
            flour.setText(count + "");
            values.put("flour", count);
            myStore.setCurrentCapacity(myStore.getCurrentCapacity()+2);
        }
    }
    public void featherButton(javafx.scene.input.MouseEvent mouseEvent)
    {
        if(myStore.canAdd(1)) {
            int count = values.get("feather");
            count++;
            feather.setText(count + "");
            values.put("feather", count);
            myStore.setCurrentCapacity(myStore.getCurrentCapacity()+1);
        }

    }
    public void milkButton(javafx.scene.input.MouseEvent mouseEvent)
    {
        if(myStore.canAdd(1)) {
            int count = values.get("milk");
            count++;
            milk.setText(count + "");
            values.put("milk", count);
            myStore.setCurrentCapacity(myStore.getCurrentCapacity()+1);
        }
    }
    public void breadButton(javafx.scene.input.MouseEvent mouseEvent)
    {
        if(myStore.canAdd(4)) {
            int count = values.get("bread");
            count++;
            bread.setText(count + "");
            values.put("bread", count);
            myStore.setCurrentCapacity(myStore.getCurrentCapacity()+4);
        }

    }
    public void clothButton(javafx.scene.input.MouseEvent mouseEvent)
    { int count =  values.get("cloth");
        count++;
        cloth.setText(count+"");
        values.put("cloth",count);

    }
    public void dressButton(javafx.scene.input.MouseEvent mouseEvent)
    { int count =  values.get("dress");
        count++;
        dress.setText(count+"");
        values.put("dress",count);

    }
    public void iceCreamButton(javafx.scene.input.MouseEvent mouseEvent)
    { int count =  values.get("iceCream");
        count++;
        iceCream.setText(count+"");
        values.put("iceCream",count);
    }
    public void lionButton(javafx.scene.input.MouseEvent mouseEvent)
    {
        if(myStore.canAdd(15)) {
            int count = values.get("lion");
            count++;
            lion.setText(count + "");
            values.put("lion", count);
            myStore.setCurrentCapacity(myStore.getCurrentCapacity()+15);
        }
    }
    public void bearButton(javafx.scene.input.MouseEvent mouseEvent)
    {
        if(myStore.canAdd(15)) {
            int count = values.get("bear");
            count++;
            bear.setText(count + "");
            values.put("bear", count);
            myStore.setCurrentCapacity(myStore.getCurrentCapacity()+15);
        }

    }
    public void tigerButton(javafx.scene.input.MouseEvent mouseEvent)
    {
        if(myStore.canAdd(15)) {
            int count = values.get("tiger");
            count++;
            tiger.setText(count + "");
            values.put("tiger", count);
            myStore.setCurrentCapacity(myStore.getCurrentCapacity()+15);
        }
    }

    public void backButton(MouseEvent mouseEvent) {
        MainGround.getStage().close();
    }
    public void sellButton(MouseEvent mouseEvent) {
      calculateTotalCost(values);
      Main.currentPlayer.setCoin(Main.currentPlayer.getCoin() + totalCost);
      MainGround.getInstance().getCoinsLabel().setText(""+Main.currentPlayer.getCoin());
      MainGround.getStage().close();
    }
}
