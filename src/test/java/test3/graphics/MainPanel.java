package test3.graphics;

import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import commonGraphics.panels.MinimalPanel;
import test3.models.Spacecraft;
import test3.player.PaintMode;
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
        @NotNull PaintMode paintMode = player.getPaintMode();
        paintCommonInfo(g, paintMode);
        switch (paintMode) {
            case FLIGHT -> paintMode_flight(g);
            case SHIPYARD -> paintMode_shipyard(g);
            case MISSIONS -> paintMode_missions(g);
            default -> paintMode_default(g);
        }
    }

    private void paintCommonInfo(@NotNull Graphics g, @NotNull PaintMode mode) {
        int textHeight = 15;
        int @NotNull [] textLocation = new int [] {20, 20};
        g.setColor(TEXT_COLOR);
        drawStringList(g, textLocation, textHeight, new ArrayList<>() {{
            add("Mode: " + mode);
            add("Money: " + player.getWallet().getMoney());
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

    private void paintMode_default(@NotNull Graphics g) {
        setDrawDiagonals(true);
        g.setColor(TEXT_COLOR);
        g.drawString("Painting for this PaintMode not defined.", 50, 50);
    }

    private void paintMode_flight(@NotNull Graphics g) {
        setDrawDiagonals(true);
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        g.setColor(TEXT_COLOR);
        g.drawString("Flight mode not ready yet...", x, y);
    }

    private void paintMode_shipyard(@NotNull Graphics g) {
        setDrawDiagonals(false);
        @NotNull List<@NotNull Spacecraft> ships = player.getOwnedShips();
        int shipCount = ships.size();
        int gap = getWidth() / (shipCount + 1);
        int @NotNull [] firstShipLocation = new int [] {gap, getHeight() / 2};
        for (int i = 0; i < shipCount; i++) {
            @NotNull Spacecraft ship = ships.get(i);
            ShipPainter.paintShip(g, ship, new int [] {firstShipLocation[0] + gap * i, firstShipLocation[1]});
        }
    }

    private void paintMode_missions(@NotNull Graphics g) {
        setDrawDiagonals(true);
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        g.setColor(TEXT_COLOR);
        g.drawString("Missions mode not ready yet...", x, y);
    }
}