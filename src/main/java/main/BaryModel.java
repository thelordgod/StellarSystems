package main;

import java.util.ArrayList;
import java.util.List;

public class BaryModel {
    private final BarySystem system;

    public BaryModel() {
        BaryObject
                obj1 = new BarySimpleObject(null),
                obj2 = new BarySimpleObject(null);
        system = new BarySystem(null);
        system.addObject(obj1);
        system.addObject(obj2);
    }

    //
    public BarySystem getSystem() {
        return system;
    }

    public static class BaryObject {
        private BarySystem parent;

        BaryObject(BarySystem parent) {
            this.parent = parent;
        }

        public void setParent(BarySystem parent) {
            this.parent = parent;
        }

        public BarySystem getParent() {
            return parent;
        }
    }

    //
    public static class BarySimpleObject extends BaryObject {
        //
        BarySimpleObject(BarySystem parent) {
            super(parent);
        }
    }

    //
    public static class BarySystem extends BaryObject {
        private final List<BaryObject> objects;

        //
        BarySystem(BarySystem parent) {
            super(parent);
            objects = new ArrayList<>();
        }

        void addObject(BaryObject object) {
            objects.add(object);
            object.setParent(this);
        }

        public List<BaryObject> getObjects() {
            return objects;
        }
    }
}