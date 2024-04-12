package test3.models;

import java.awt.Color;

import org.jetbrains.annotations.NotNull;

//
public class Spacecraft {
    private final @NotNull String name;
    private final @NotNull StructuralModule core;
    private final @NotNull Color color; //for graphical purposes

    //
    public Spacecraft(@NotNull String name, @NotNull StructuralModule core) {
        this.name = name;
        this.core = core;
        color = Color.red;
    }

    //
    public @NotNull String getName() {
        return name;
    }

    //
    public @NotNull StructuralModule getCore() {
        return core;
    }

    //gets the total size of the ship
    public int getSize() {
        //TODO: improve this
        return core.getSize();
    }

    //for graphical purposes
    public @NotNull Color getColor() {
        return color;
    }
}