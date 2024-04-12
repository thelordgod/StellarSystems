package playerTest.graphics.panels.leftSidePanel;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static consoleUtils.SimplePrinting.printLine;

import commonGraphics.UpdatingWindow;
import commonGraphics.panels.sidePanels.commonLeftSidePanel.CommonLeftSidePanel;
import commonGraphics.panels.sidePanels.commonLeftSidePanel.CommonTopSection;

//
public final class LeftSidePanel extends CommonLeftSidePanel {
    private static final @Nullable Color DIAGONAL_COLOR = null;

    //uses default width
    public LeftSidePanel(@NotNull UpdatingWindow window,
                         @Nullable Color background, @Nullable Color borderColor) {
        super(
                window, background,
                Color.red/*borderColor*/, true, true,
                DIAGONAL_COLOR, true, true);
        printLine("Creating left side panel");
        addSections();
    }

    //
    @Override
    public @NotNull CommonTopSection getNewTopSection() {
        return new TopSection(getSectionBorderColor(), getSectionDiagonalColor());
    }
}