package commonGraphics.panels.sidePanels;

import java.awt.Color;

import org.jetbrains.annotations.Nullable;

import commonGraphics.panels.FixedHorizontalPanel;

//a horizontal section for a vertical side-panel
public abstract class AbstractSectionPanel extends FixedHorizontalPanel {
    //
    public AbstractSectionPanel(int height,
                                @Nullable Color borderColor, boolean drawBorders,
                                @Nullable Color diagonalColor, boolean drawDiagonals) {
        super(
                height, null,
                borderColor, drawBorders,
                diagonalColor, drawDiagonals);
    }
}