package test3.models;

import java.awt.Color;
import java.util.List;

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

    //
    public @NotNull List<@NotNull ModuleConnection> getFreeConnections() {
        @NotNull List<@NotNull ModuleConnection> freeConnections = core.getFreeConnections();



        return freeConnections;
    }

    //gets the total size of the ship
    public int getSize() {
        //TODO: improve this and remove the "+10"
        return core.getSize() + 10;
    }

    //for graphical purposes
    public @NotNull Color getColor() {
        return color;
    }

    public void addModule(SpacecraftModule part) {
    }
}