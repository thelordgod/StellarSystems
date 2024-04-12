package playerTest.graphics.panels.centralPanel;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static commonGraphics.ColorUtils.getGray;
import static commonGraphics.StringUtils.drawNumberedString;
import static consoleUtils.SimplePrinting.printLine;

import commonGraphics.panels.sidePanels.AbstractSectionPanel;

//
final class BottomSection extends AbstractSectionPanel {
    private static final int PANEL_HEIGHT = 300;
    private static final int @NotNull [] TEXT_LOCATION = new int [] {10, 10};
    private static final @NotNull Color
            HEADING_COLOR = Color.white,
            TEXT_COLOR = getGray(170, 255);

    //
    BottomSection(@Nullable Color borderColor, @Nullable Color diagonalColor) {
        super(
                PANEL_HEIGHT,
                borderColor, true,
                diagonalColor, true);
        printLine("Creating central panel bottom section");
        printSizeToConsole("");
    }

    //
    @Override
    public void mainPaint(@NotNull Graphics g) {
        g.setColor(HEADING_COLOR);
        drawInfoLine(g, "Bottom section", 1);
        //TODO: improve this
        g.setColor(TEXT_COLOR);
        drawInfoLine(g, "Coming soon...", 2);
        // Paint more stuff here, if needed.
    }

    @SuppressWarnings("SameParameterValue")
    private void drawInfoLine(@NotNull Graphics g, @Nullable String line, int lineNumber) {
        drawNumberedString(g, line, TEXT_LOCATION, lineNumber);
    }
}