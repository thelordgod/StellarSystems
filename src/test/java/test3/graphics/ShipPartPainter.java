package test3.graphics;

import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import test3.models.SpacecraftModule;

//
final class ShipPartPainter {
    //
    static void paintShipPart(@NotNull Graphics g, @NotNull SpacecraftModule part, int @NotNull [] paintCenter) {
        int size = part.getSize();
        int @NotNull [] drawStart = new int [] {
                paintCenter[0] - size / 2,
                paintCenter[1] - size / 2};
        g.setColor(part.getColor());
        g.drawRect(drawStart[0], drawStart[1], size, size);
    }
}