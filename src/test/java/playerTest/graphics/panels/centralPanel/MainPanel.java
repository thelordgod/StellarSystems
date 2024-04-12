package playerTest.graphics.panels.centralPanel;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import commonGraphics.panels.graphicalPanels.CenteredDrawPanel;
import commonGraphics.panels.graphicalPanels.ScaledDrawInterface;

import static consoleUtils.SimplePrinting.printLine;
import static consoleUtils.stringTools.NumberFormatter.doubleToString;

//
public class MainPanel extends CenteredDrawPanel implements ScaledDrawInterface {
    private static final double DEFAULT_SCALE = 2.0;
    private static final @NotNull Color
            BACKGROUND = Color.black,
            TEXT_COLOR = Color.red;//Color.white;
    @SuppressWarnings("FieldMayBeFinal")
    private double scale;

    //
    public MainPanel(@Nullable Color borderColor, @Nullable Color diagonalColor) {
        super(
                null,//BACKGROUND,
                borderColor, false,
                /*diagonalColor*/Color.red, true);
        printLine("Creating main panel");
        scale = DEFAULT_SCALE;
        printSizeToConsole("");
    }

    //
    @Override
    public double getScale() {
        return scale;
    }

    //
    @Override
    public void mainPaint(@NotNull Graphics g) {
        g.setColor(TEXT_COLOR);
        g.drawString("A player test", 100, 100);
        g.drawString("Scale: " + doubleToString(scale, 3), 100, 120);
        // Paint more stuff here, if needed.
    }
}