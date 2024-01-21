package baryModel;

//
public class BaryModel {
    private final BaryUniverse universe;

    //
    public BaryModel() {
        universe = new BaryUniverse();
    }

    //
    public BaryUniverse getUniverse() {
        return universe;
    }

    public void recalculate(double time) {
        universe.recalculate(time);
    }
}