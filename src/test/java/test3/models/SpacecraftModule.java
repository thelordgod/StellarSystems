package test3.models;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

//
public abstract class SpacecraftModule {
    private final @NotNull String name;
    private final int size;
    private final @NotNull Color color; // for graphical purposes

    //
    protected SpacecraftModule(@NotNull String name, int size, @NotNull Color color) {
        this.name = name;
        this.size = size;
        this.color = color;
    }

    //
    public @NotNull String getName() {
        return name;
    }

    //
    public int getSize() {
        return size;
    }

    //for graphical purposes
    public @NotNull Color getColor() {
        return color;
    }
}