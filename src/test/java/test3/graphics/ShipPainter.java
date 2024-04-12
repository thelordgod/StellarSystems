package test3.graphics;

import java.awt.Graphics;

import org.jetbrains.annotations.NotNull;

import test3.models.Spacecraft;

//
final class ShipPainter {
    static void paintShip(@NotNull Graphics g, @NotNull Spacecraft ship, int @NotNull [] location) {
        int size = ship.getSize();
        int @NotNull [] drawStart = new int [] {
                location[0] - size / 2,
                location[1] - size / 2};
        g.setColor(ship.getColor());
        g.drawRect(drawStart[0], drawStart[1], size, size);
    }
}