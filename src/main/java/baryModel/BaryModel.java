package baryModel;

//
public class BaryModel implements BufferedValueInterface {
    private final BaryUniverse universe;

    //
    public BaryModel() {
        universe = new BaryUniverse();
    }

    //
    public BaryUniverse getUniverse() {
        return universe;
    }

    @Override
    public void precalculate(double time) {
        universe.precalculate(time);
    }

    @Override
    public void update() {
        universe.update();
    }
}