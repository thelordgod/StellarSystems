package testGraphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import main.BaryModel;

//
public class TestPanel extends JPanel {
    private static final Color
            BACKGROUND_COLOR = Color.black,
            TEXT_COLOR = Color.yellow;
    private static final double SCALE = 2.0;
    private final BaryModel model;

    //
    TestPanel(BaryModel model) {
        super();
        this.model = model;
        setBackground(BACKGROUND_COLOR);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(TEXT_COLOR);
        g.drawString("A test text!", 100, 100);
        paintBaryObject(g, new int [] {100, 100}, model.getUniverse(), new double [2]);
    }

    private void paintBaryObject(Graphics g, int [] drawOffset,
                                 BaryModel.BaryObject object,
                                 double [] parentLocation) {
        double []
                relativeLocation = object.getLocation().getCartesian(),
                absoluteLocation = new double [] {
                        parentLocation[0] + relativeLocation[0],
                        parentLocation[1] + relativeLocation[1]};
        if (object instanceof BaryModel.BarySimpleObject) {
            paintSimpleBaryObject(g, drawOffset, (BaryModel.BarySimpleObject) object, absoluteLocation);
        } else if (object instanceof BaryModel.BarySystem) {
            paintBarySystem(g, drawOffset, (BaryModel.BarySystem) object, absoluteLocation);
        } else {
            throw new RuntimeException("BaryObject not of a recognized type!");
        }
    }

    private void paintSimpleBaryObject(Graphics g, int [] drawOffset,
                                       BaryModel.BarySimpleObject simpleObject,
                                       double [] absoluteLocation) {
        double [] scaledLocation = new double [] {
                absoluteLocation[0] / SCALE,
                absoluteLocation[1] / SCALE};
        double
                actualSize = 10,
                scaledSize = actualSize / SCALE;
        g.setColor(Color.CYAN);
        g.fillOval(
                (int) (scaledLocation[0] - scaledSize / 2 + drawOffset[0]),
                (int) (scaledLocation[1] - scaledSize / 2 + drawOffset[1]),
                (int) scaledSize, (int) scaledSize);
        //TODO: paint an individual simple body here
    }

    private void paintBarySystem(Graphics g, int [] drawOffset,
                                 BaryModel.BarySystem system,
                                 double [] absoluteLocation) {
        //TODO: paint some general system-wide data here
        for (BaryModel.BaryObject object : system.getObjects()) {
            paintBaryObject(g, drawOffset, object, absoluteLocation);
        }
    }
}