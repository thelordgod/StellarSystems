package main;

import java.util.List;
import java.util.ArrayList;

//
public class BaryModel {
    private final BaryUniverse universe;

    //
    public BaryModel() {
        universe = new BaryUniverse();

        BaryObject
                independentObject = new BarySimpleObject(null, newBaryLocationFromCartesian(300, 0, 0));
        universe.addObject(independentObject);

        BaryObject
                dependentObject1 = new BarySimpleObject(null, newBaryLocationFromCartesian(50, 0, 0)),
                dependentObject2 = new BarySimpleObject(null, newBaryLocationFromCartesian(150, 0, 0));
        BarySystem system = new BarySystem(null, newBaryLocationFromCartesian(100, 0, 0));
        system.addObject(dependentObject1);
        system.addObject(dependentObject2);
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

        //returns [x, y]
        public double [] getCartesian() {
            return new double [] {
                    distance * Math.cos(phaseAngle),
                    distance * Math.sin(phaseAngle)};
        }
    }

    //
    static BaryLocation newBaryLocationFromRadial(double distance, double phaseAngle, double angularVelocity) {
        return new BaryLocation(distance, phaseAngle, angularVelocity);
    }

    //untested, probably doesn't work at extremes
    static BaryLocation newBaryLocationFromCartesian(double x, double y, double angularVelocity) {
        return new BaryLocation(
                Math.hypot(x, y),
                getAngle(x, y),
                angularVelocity);
    }

    //very bad angle calculations
    static double getAngle(double x, double y) {
        if (x == 0) {
            double straightAngle = Math.PI / 2;
            if (y > 0) {
                return straightAngle;
            }
            if (y < 0) {
                return straightAngle * 3;
            }
            return 0;
        }
        double arcTangent = Math.atan(y / x);
        if (x < 0) {
            return arcTangent + Math.PI;
        }
        if (x > 0 && y < 0) {
            return arcTangent + Math.PI * 2;
        }
        return arcTangent;
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
            super(null, new BaryLocation(0, 0, 0));
        }
    }
}