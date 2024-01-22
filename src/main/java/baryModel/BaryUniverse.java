package baryModel;

import java.awt.Color;

//
public class BaryUniverse extends BarySystem {
    //
    public BaryUniverse() {
        super(null, BaryLocation.BaryLocationGenerator.newBaryLocationFromCartesian(0, 0,0), Color.white);
    }
}