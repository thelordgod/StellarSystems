package test3.graphics;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

import commonGraphics.ColorUtils;

//
final class PanelPalette {
    @SuppressWarnings("FieldMayBeFinal")
    private @NotNull Color
            mainBackground, panelBackground,
            panelBorder, panelDiagonals;

    public PanelPalette() {
        mainBackground = Color.black;
        panelBackground = ColorUtils.getOpaqueGray(45);
        panelBorder = ColorUtils.getOpaqueGray(30);
        panelDiagonals = new Color(255, 120, 0);
    }

    //
    public @NotNull Color getMainBackground() {
        return mainBackground;
    }

    //
    public @NotNull Color getPanelBackground() {
        return panelBackground;
    }

    //
    public @NotNull Color getPanelBorder() {
        return panelBorder;
    }

    //
    public @NotNull Color getPanelDiagonals() {
        return panelDiagonals;
    }
}