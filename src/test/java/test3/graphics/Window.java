package test3.graphics;

import java.awt.LayoutManager;
import javax.swing.BoxLayout;

import commonGraphics.UpdatingWindow;

//
public class Window extends UpdatingWindow {

    //
    public Window() {
        super(new TestWindowSettings()); //default frame rate
        //add stuff before panels here
        addPanels();
        //add key listener here
        revalidate();
        startUpdating();
    }

    //
    @Override
    public void addPanels() {
        LayoutManager layout = new BoxLayout(getContentPane(), BoxLayout.X_AXIS);
        getContentPane().setLayout(layout);
        add(new Panel());
        // Add more panels here, if needed.
    }
}