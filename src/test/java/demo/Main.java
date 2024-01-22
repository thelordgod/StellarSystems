package demo;

import java.awt.Color;

import ThreadAbstraction.AbstractUpdater;

import static baryModel.BaryLocation.BaryLocationGenerator.newBaryLocationFromRadial;
import static baryModel.BaryLocation.BaryLocationGenerator.newBaryLocationFromCartesian;

import baryModel.BaryObject;
import baryModel.BarySimpleObject;
import baryModel.BarySystem;
import baryModel.BaryUniverse;
import baryModel.BaryModel;

import testGraphics.TestWindow;
import testGraphics.WindowUpdater;

//
public class Main {
    private static final BaryModel BARY_MODEL;

    static {
        BARY_MODEL = new MyBaryModel();
    }

    //
    public static void main(String[] args) {
        //TODO: do something here
        (new ModelUpdater(BARY_MODEL)).start();
        startGraphics();
    }

    private static void startGraphics() {
        new WindowUpdater(new TestWindow(BARY_MODEL));
    }

    private static class MyBaryModel extends BaryModel {
        private MyBaryModel() {
            super();
            BaryUniverse universe = getUniverse();
            BaryObject
                    independentObject = new BarySimpleObject(
                            null,
                            newBaryLocationFromRadial(500, Math.PI, 0.3),
                            Color.CYAN);
            universe.addObject(independentObject);

            BaryObject
                    dependentObject1 = new BarySimpleObject(
                            null,
                            newBaryLocationFromRadial(70, 0, 2),
                            Color.YELLOW),
                    dependentObject2 = new BarySimpleObject(
                            null,
                            newBaryLocationFromRadial(100, Math.PI * 2 / 3, 1.5),
                            Color.ORANGE);
            BarySystem system = new BarySystem(
                    null,
                    newBaryLocationFromCartesian(220, 0, 0.6),
                    Color.MAGENTA);
            system.addObject(dependentObject1);
            system.addObject(dependentObject2);
            universe.addObject(system);
        }
    }

    private static class ModelUpdater extends AbstractUpdater {
        private static final long DELAY = 30;
        private final BaryModel model;

        private ModelUpdater(BaryModel model) {
            super(DELAY);
            this.model = model;
        }

        @Override
        public void update() {
            double totalElapsedTimeInSeconds = (delayCalculator.getElapsedTime() + delayCalculator.getDelay()) / 1000.0;
            model.precalculate(totalElapsedTimeInSeconds);
            model.update();
        }
    }
}