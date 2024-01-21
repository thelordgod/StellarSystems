package testGraphics;

import main.BaryModel;

import java.awt.*;
import javax.swing.JPanel;

//
public class TestPanel extends JPanel {
    private static final Color
            BACKGROUND_COLOR = Color.black,
            TEXT_COLOR = Color.yellow;
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
    }
}