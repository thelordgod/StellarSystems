package baryModel;

//Keplerian-based 2D polar coordinates
public class BaryLocation implements BufferedValueInterface {
    @SuppressWarnings("FieldMayBeFinal")
    private double
            distance,
            phaseAngle, phaseAngleTemp,
            angularVelocity;

    //
    private BaryLocation(double distance, double phaseAngle, double angularVelocity) {
        this.distance = distance;
        this.phaseAngle = phaseAngle;
        phaseAngleTemp = phaseAngle;
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
    public double[] getCartesian() {
        return new double[]{
                distance * Math.cos(phaseAngle),
                distance * Math.sin(phaseAngle)};
    }

    @Override
    public void precalculate(double time) {
        phaseAngleTemp = phaseAngle + angularVelocity * time;
    }

    @Override
    public void update() {
        phaseAngle = phaseAngleTemp;
    }

    public static class BaryLocationGenerator {
        //
        public static BaryLocation newBaryLocationFromRadial(double distance, double phaseAngle, double angularVelocity) {
            return new BaryLocation(distance, phaseAngle, angularVelocity);
        }

        //untested, probably doesn't work at extremes
        public static BaryLocation newBaryLocationFromCartesian(double x, double y, double angularVelocity) {
            return new BaryLocation(
                    Math.hypot(x, y),
                    getAngle(x, y),
                    angularVelocity);
        }

        //very bad x-y to angle calculations
        private static double getAngle(double x, double y) {
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
    }
}