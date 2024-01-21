package baryModel;

import java.awt.Color;

//
public class BaryObject {
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

    public void recalculate(double time) {
        location.recalculate(time);
    }

    public Color getColor() {
        return color;
    }
}