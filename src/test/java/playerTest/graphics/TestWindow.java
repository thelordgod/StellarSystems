package playerTest.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static commonGraphics.ColorUtils.getGray;
import static consoleUtils.SimplePrinting.printLine;

import commonGraphics.panels.MinimalPanel;
import commonGraphics.UpdatingWindow;
import playerTest.graphics.panels.leftSidePanel.LeftSidePanel;
import playerTest.graphics.panels.centralPanel.CentralPanel;
import playerTest.graphics.panels.rightSidePanel.RightSidePanel;

//
public final class TestWindow extends UpdatingWindow {
    private static final @NotNull Color
            MAIN_PANEL_BACKGROUND_COLOR = getGray(50, 255),
            MAIN_PANEL_BORDER_COLOR = getGray(40, 255);

    //
    public TestWindow() {
        super(new TestWindowSettings());
        //observer = new Observer();
        addPanels();
        //addKeyListener();
        revalidate();
        startUpdating();
    }

    //
    @Override
    public void addPanels() {
        LayoutManager layout = new BoxLayout(getContentPane(), BoxLayout.X_AXIS);
        getContentPane().setLayout(layout);
        @NotNull LeftSidePanel leftSidePanel = new LeftSidePanel(
                this,
                MAIN_PANEL_BACKGROUND_COLOR, MAIN_PANEL_BORDER_COLOR);
        add(leftSidePanel);
        @NotNull CentralAndRightPanel centralAndRightPanel = new CentralAndRightPanel(
                MAIN_PANEL_BACKGROUND_COLOR, MAIN_PANEL_BORDER_COLOR);
        add(centralAndRightPanel);

        //debugging:
        revalidate();
        leftSidePanel.printSizeToConsole("Left side panel created,");
        centralAndRightPanel.printSizeToConsole("CentralAndRightPanel created,");
    }

    //
    private static final class CentralAndRightPanel extends MinimalPanel {
        //
        CentralAndRightPanel(@Nullable Color mainPanelBackgroundColor, @Nullable Color mainPanelBorderColor) {
            super(null, null, false, null, false);
            printLine("Creating CentralAndRightPanel");
            LayoutManager layout = new BorderLayout();
            setLayout(layout);
            @NotNull RightSidePanel rightSidePanel = new RightSidePanel(mainPanelBackgroundColor, mainPanelBorderColor);
            //add(rightSidePanel, BorderLayout.EAST);
            @NotNull CentralPanel centralPanel = new CentralPanel(mainPanelBackgroundColor, mainPanelBorderColor);
            add(centralPanel);
            revalidate();

            //debugging:
            rightSidePanel.printSizeToConsole("Right side panel created,");
            centralPanel.printSizeToConsole("Central panel created,");
        }

        //
        @Override
        public void mainPaint(@NotNull Graphics g) {}
    }
}