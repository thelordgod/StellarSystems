package main;

import java.util.ArrayList;
import java.util.List;

public class BaryModel {
    private final BaryUniverse universe;

    public BaryModel() {
        universe = new BaryUniverse();

        BaryObject
                independentObject = new BarySimpleObject(null, null);
        universe.addObject(independentObject);

        BaryObject
                dependentObject1 = new BarySimpleObject(null, null),
                dependentObject2 = new BarySimpleObject(null, null);
        BarySystem system = new BarySystem(null, null);
        system.addObject(dependentObject1);
        system.addObject(dependentObject1);
        universe.addObject(system);
    }

    //
    public BaryUniverse getUniverse() {
        return universe;
    }

    //
    public static class BaryLocation {
        @SuppressWarnings("FieldMayBeFinal")
        private double
                distance,
                phaseAngle,
                angularVelocity;

        //
        BaryLocation(double distance, double phaseAngle, double angularVelocity) {
            this.distance = distance;
            this.phaseAngle = phaseAngle;
            this.angularVelocity = angularVelocity;
        }

        //
        public double getDistance() {
            return distance;
        }

        //
        public double getPhaseAngle() {
            return phaseAngle;
        }

        //
        public double getAngularVelocity() {
            return angularVelocity;
        }
    }

    //
    static BaryLocation newBaryLocationFromRadial(double distance, double phaseAngle, double angularVelocity) {
        return new BaryLocation(distance, phaseAngle, angularVelocity);
    }

    //untested, probably doesn't work at extremes
    static BaryLocation newBaryLocationFromCartesian(double x, double y, double angularVelocity) {
        double
                distance = Math.hypot(x, y),
                phaseAngle = Math.atan(y / x);
        return new BaryLocation(distance, phaseAngle, angularVelocity);
    }

    public static class BaryObject {
        private BarySystem parent;
        private BaryLocation location;

        BaryObject(BarySystem parent, BaryLocation location) {
            this.parent = parent;
            this.location = location;
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
    }

    //
    public static class BarySimpleObject extends BaryObject {
        //
        BarySimpleObject(BarySystem parent, BaryLocation location) {
            super(parent, location);
        }
    }

    //
    public static class BarySystem extends BaryObject {
        private final List<BaryObject> objects;

        //
        BarySystem(BarySystem parent, BaryLocation location) {
            super(parent, location);
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

    //
    public static class BaryUniverse extends BarySystem {
        //
        BaryUniverse() {
            super(null, null);
        }
    }
}