package testGraphics;

import main.BaryModel;

import java.awt.Color;
import javax.swing.JPanel;

//
public class TestPanel extends JPanel {
    private final BaryModel model;

    //
    TestPanel(BaryModel model) {
        super();
        this.model = model;
        setBackground(Color.magenta);
    }
}