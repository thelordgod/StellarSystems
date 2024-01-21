package baryModel;

import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

//
public class BarySystem extends BaryObject {
    private final List<BaryObject> objects;

    //
    public BarySystem(BarySystem parent, BaryLocation location, Color color) {
        super(parent, location, color);
        objects = new ArrayList<>();
    }

    public void addObject(BaryObject object) {
        objects.add(object);
        object.setParent(this);
    }

    public List<BaryObject> getObjects() {
        return objects;
    }
}