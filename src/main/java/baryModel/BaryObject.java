package baryModel;

import java.awt.Color;

//
public class BaryObject implements BufferedValueInterface {
    private BarySystem parent;
    private BaryLocation location;
    private final Color color;

    public BaryObject(BarySystem parent, BaryLocation location, Color color) {
        this.parent = parent;
        this.location = location;
        this.color = color;
    }

    public void setParent(BarySystem parent) {
        this.parent = parent;
    }

    public BarySystem getParent() {
        return parent;
    }

    public void setLocation(BaryLocation location) {
        this.location = location;
    }

    public BaryLocation getLocation() {
        return location;
    }

    @Override
    public void precalculate(double time) {
        location.precalculate(time);
    }

    @Override
    public void update() {
        location.update();
    }

    public Color getColor() {
        return color;
    }
}