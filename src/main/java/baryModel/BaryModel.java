package baryModel;

import java.awt.*;

import static baryModel.BaryLocation.newBaryLocationFromCartesian;
import static baryModel.BaryLocation.newBaryLocationFromRadial;

//
public class BaryModel {
    private final BaryUniverse universe;

    //
    public BaryModel() {
        universe = new BaryUniverse();

        BaryObject
                independentObject = new BarySimpleObject(null, newBaryLocationFromCartesian(500, 0, 0), Color.CYAN);
        universe.addObject(independentObject);

        BaryObject
                dependentObject1 = new BarySimpleObject(null, newBaryLocationFromRadial(50, 0, 0), Color.YELLOW),
                dependentObject2 = new BarySimpleObject(null, newBaryLocationFromRadial(50, Math.PI * 2 / 3, 0), Color.ORANGE);
        BarySystem system = new BarySystem(null, newBaryLocationFromCartesian(200, 0, 0), Color.MAGENTA);
        system.addObject(dependentObject1);
        system.addObject(dependentObject2);
        universe.addObject(system);
    }

    //
    public BaryUniverse getUniverse() {
        return universe;
    }
}