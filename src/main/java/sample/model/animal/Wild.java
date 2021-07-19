package sample.model.animal;

import sample.model.Ground;
import sample.model.Storable;
import sample.util.RandomUtil;

public abstract class Wild extends Animal implements Storable {
    protected int speed;
    protected int sellPrice;
    protected int hitsToKill;

    public Wild(int x, int y) {
        super(x, y);
    }

    public void kill(Animal toDie, int targetX, int targetY) {
        this.setX(targetX);
        this.setY(targetY);
        animals.remove(toDie); // the domestic one dies, wild one replaces
    }
}
