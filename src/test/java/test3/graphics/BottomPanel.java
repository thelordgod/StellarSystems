package test3.graphics;

import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import commonGraphics.panels.FixedHorizontalPanel;
import test3.models.SpacecraftModule;
import test3.player.Player;

//
public class BottomPanel extends FixedHorizontalPanel {
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
                infoY = 180, textOffsetX = -15;
        @NotNull List<@NotNull SpacecraftModule> partInventory = player.getShipPartInventory();
        for (int i = 0; i < partInventory.size(); i++) {
            @NotNull SpacecraftModule part = partInventory.get(i);
            int partX = partDrawLocation[0] + partSeparation * i;
            paintShipPart(g, part, new int [] {partX, partDrawLocation[1]});
            paintPartInfo(g, part, new int [] {partX + textOffsetX, infoY});
        }
    }

    private void paintShipPart(@NotNull Graphics g, @NotNull SpacecraftModule part, int @NotNull [] location) {
        @NotNull Color partColor = Color.green;
        int size = 50;
        int @NotNull [] drawStart = new int [] {location[0] - size / 2, location[1] - size / 2};
        g.setColor(partColor);
        g.drawRect(drawStart[0], drawStart[1], size, size);
    }

    private void paintPartInfo(@NotNull Graphics g, @NotNull SpacecraftModule part, int @NotNull [] location) {
        int textHeight = 15;
        g.setColor(TEXT_COLOR);
        drawStringList(g, location, textHeight, new ArrayList<>() {{
            add("Part: ");
            add("coming soon");
        }});
    }

    private void drawStringList(@NotNull Graphics g, int @NotNull [] location, int textHeight,
                                @NotNull List<@Nullable String> list) {
        for (int i = 0; i < list.size(); i++) {
            @Nullable String string = list.get(i);
            if (string != null) {
                g.drawString(string, location[0], location[1] + textHeight * (i + 1));
            }
        }
    }

    private void paintMode_missions(@NotNull Graphics g) {
        setDrawDiagonals(true);
        g.setColor(TEXT_COLOR);
        g.drawString("Missions mode not ready yet...", 50, 50);
    }
}