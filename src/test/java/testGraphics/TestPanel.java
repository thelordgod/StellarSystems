package testGraphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import baryModel.BaryModel;

//
class TestPanel extends JPanel {
    private static final Color BACKGROUND_COLOR = Color.black;
    private final BaryPainter baryPainter;

    //
    protected TestPanel(BaryModel model) {
        super();
        setBackground(BACKGROUND_COLOR);
        baryPainter = new BaryPainter(model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        baryPainter.paint(g);
        //TODO: paint something else here
    }
}