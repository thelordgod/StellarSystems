package test3.graphics;

import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import test3.models.SpacecraftModule;

//
final class ShipPartPainter {
    private static final int TEXT_HEIGHT = 15;

    //call this to paint part only; returns within status (true, if mouse is within this part)
    static boolean paintShipPart(@NotNull Graphics g, @NotNull SpacecraftModule part, int @NotNull [] paintCenter,
                              int @NotNull [] mouseLocation) {
        int size = part.getSize();
        int @NotNull [] drawStart = new int [] {
                paintCenter[0] - size / 2,
                paintCenter[1] - size / 2};
        g.setColor(part.getColor());
        boolean within = within(drawStart, size, mouseLocation);
        if (within) {
            g.fillRect(drawStart[0], drawStart[1], size, size);
        } else {
            g.drawRect(drawStart[0], drawStart[1], size, size);
        }
        return within;
    }

    private static boolean within(int @NotNull [] drawStart, int size, int @NotNull [] target) {
        boolean
                withinX = (target[0] >= drawStart[0]) && (target[0] <= drawStart[0] + size),
                withinY = (target[1] >= drawStart[1]) && (target[1] <= drawStart[1] + size);
        return withinX && withinY;
    }

    //call this to paint part info only
    static void paintPartInfo(@NotNull Graphics g, @NotNull SpacecraftModule part,
                              @NotNull Color textColor, int @NotNull [] location) {
        g.setColor(textColor);
        drawStringList(g, location, TEXT_HEIGHT, new ArrayList<>() {{
            add(part.getName());
            //add more part info lines here
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