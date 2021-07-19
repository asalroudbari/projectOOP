package sample.view;

import sample.view.AnimalsRect.MyRectAngle;

public class WildAnimation extends Animation{

    public WildAnimation(MyRectAngle rect, int theta, int speed) {
        super(rect, theta, speed);
    }

    @Override
    protected void interpolate(double v) {
        super.interpolate(v);

    }
}
