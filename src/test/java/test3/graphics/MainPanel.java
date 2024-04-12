package test3.graphics;

import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import commonGraphics.panels.MinimalPanel;
import test3.player.Player;

//
final class MainPanel extends MinimalPanel {
    private static final @NotNull Color TEXT_COLOR = Color.white;
    private final @NotNull Player player;

    //
    MainPanel(@NotNull Player player, @NotNull PanelPalette palette) {
        super(
                palette.getMainBackground(),
                palette.getPanelBorder(), true,
                palette.getPanelDiagonals(), false);
        this.player = player;
    }

    //
    @Override
    public void mainPaint(@NotNull Graphics g) {
        switch (player.getPaintMode()) {
            case FLIGHT -> paintMode_flight(g);
            case SHIPYARD -> paintMode_shipyard(g);
            case MISSIONS -> paintMode_missions(g);
            default -> paintMode_default(g);
        }
    }

    private void paintMode_default(@NotNull Graphics g) {
        setDrawDiagonals(true);
        g.setColor(TEXT_COLOR);
        g.drawString("Painting for this PaintMode not defined.", 50, 50);
    }

    private void paintMode_flight(@NotNull Graphics g) {
        setDrawDiagonals(true);
        g.setColor(TEXT_COLOR);
        g.drawString("Flight mode not ready yet...", 50, 50);
    }

    private void paintMode_shipyard(@NotNull Graphics g) {
        setDrawDiagonals(true);
        g.setColor(TEXT_COLOR);
        g.drawString("Shipyard mode not ready yet...", 50, 50);
    }

    private void paintMode_missions(@NotNull Graphics g) {
        setDrawDiagonals(true);
        g.setColor(TEXT_COLOR);
        g.drawString("Missions mode not ready yet...", 50, 50);
    }
}