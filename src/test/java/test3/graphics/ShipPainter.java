package test3.graphics;

import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import test3.models.Spacecraft;

//
final class ShipPainter {
    private static final int TEXT_HEIGHT = 15;

    //call this to paint
    static void paintShip(@NotNull Graphics g, @NotNull Spacecraft ship, int @NotNull [] location) {
        paintParts(g, ship, location);
        paintOutline(g, ship, location);
        int shipInfoOffsetX = -20;
        int @NotNull [] shipInfoLocation = new int [] {
                location[0] + shipInfoOffsetX,
                location[1] + ship.getSize() / 2};
        paintShipInfo(g, ship, ship.getColor(), shipInfoLocation);
    }

    private static void paintParts(@NotNull Graphics g, @NotNull Spacecraft ship, int @NotNull [] location) {
        ShipPartPainter.paintShipPart(g, ship.getCore(), location, new int[2]);
    }

    private static void paintOutline(@NotNull Graphics g, @NotNull Spacecraft ship, int @NotNull [] location) {
        int size = ship.getSize();
        int @NotNull [] drawStart = new int [] {
                location[0] - size / 2,
                location[1] - size / 2};
        g.setColor(ship.getColor());
        g.drawRect(drawStart[0], drawStart[1], size, size);
    }

    private static void paintShipInfo(@NotNull Graphics g, @NotNull Spacecraft ship, @NotNull Color textColor, int @NotNull [] location) {
        //
        g.setColor(textColor);
        drawStringList(g, location, TEXT_HEIGHT, new ArrayList<>() {{
            add(ship.getName());
            //add more ship info lines here
        }});
    }

    @SuppressWarnings("SameParameterValue")
    private static void drawStringList(@NotNull Graphics g, int @NotNull [] location, int textHeight,
                                       @NotNull List<@Nullable String> list) {
        for (int i = 0; i < list.size(); i++) {
            @Nullable String string = list.get(i);
            if (string != null) {
                g.drawString(string, location[0], location[1] + textHeight * (i + 1));
            }
        }
    }
}