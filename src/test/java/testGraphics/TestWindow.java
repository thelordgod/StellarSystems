package testGraphics;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.WindowConstants;
import javax.swing.JFrame;

import baryModel.BaryModel;

//A graphical window for testing purposes.
public class TestWindow extends JFrame {
    private static final Dimension WINDOW_SIZE = new Dimension(900, 700);
    private static final Point WINDOW_LOCATION = new Point(150, 100);
    private static final String WINDOW_TITLE = "A window title!";
    private final BaryModel model;

    //Creates a new window.
    public TestWindow(BaryModel model) {
        super();
        setWindowConfig();
        this.model = model;
        addPanels();
        setVisible(true);
    }

    private void setWindowConfig() {
        setSize(WINDOW_SIZE);
        setLocation(WINDOW_LOCATION);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(WINDOW_TITLE);
    }

    private void addPanels() {
        add(new TestPanel(model));
        //add more panels here
    }
}