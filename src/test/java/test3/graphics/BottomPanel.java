package test3.graphics;

import java.util.List;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import commonGraphics.panels.FixedHorizontalPanel;
import test3.models.SpacecraftModule;
import test3.player.Player;

//
final class BottomPanel extends FixedHorizontalPanel {
    private static final int PANEL_HEIGHT = 300;
    private static final @NotNull Color TEXT_COLOR = Color.white;
    private final @NotNull Player player;

    //
    public BottomPanel(@NotNull Player player, @NotNull PanelPalette palette) {
        super(PANEL_HEIGHT, palette.getPanelBackground(),
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
        setDrawDiagonals(false);
        int @NotNull [] partDrawLocation = new int [] {100, 100};
        int
                partSeparation = 160,
                infoY = 180, textOffsetX = -40;
        @NotNull List<@NotNull SpacecraftModule> partInventory = player.getShipPartInventory();
        for (int i = 0; i < partInventory.size(); i++) {
            @NotNull SpacecraftModule part = partInventory.get(i);
            int partX = partDrawLocation[0] + partSeparation * i;
            ShipPartPainter.paintShipPart(g, part, new int [] {partX, partDrawLocation[1]});
            ShipPartPainter.paintPartInfo(g, part, TEXT_COLOR, new int [] {partX + textOffsetX, infoY});
        }
    }

    private void paintMode_missions(@NotNull Graphics g) {
        setDrawDiagonals(true);
        g.setColor(TEXT_COLOR);
        g.drawString("Missions mode not ready yet...", 50, 50);
    }
}