package test3.models;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//
public abstract class SpacecraftModule {
    private final @NotNull String name;
    private final int size;
    private final @NotNull Color color; // for graphical purposes
    private @NotNull List<@NotNull ModuleConnection> connections;

    //
    protected SpacecraftModule(@NotNull String name, int size, @NotNull Color color) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.connections = new ArrayList<>();
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

    public void addConnection(@NotNull ModuleConnection connection){
        connections.add(connection);
    }

    //
    public @NotNull List<@NotNull ModuleConnection> getConnections(){
        return connections;
    }

    //
    public @Nullable ModuleConnection getParentConnection() {
        for (@NotNull ModuleConnection connection : connections) {
            if (connection.getIsParentConnection()) {
                return connection;
            }
       }
        return null;
    }

    //
    public @NotNull List<@NotNull ModuleConnection> getFreeConnections() {
        @NotNull List<@NotNull ModuleConnection> freeConnections = new ArrayList<>();
        for (@NotNull ModuleConnection connection : connections) {
            if (connection.getTetheredConnection() == null) {
                freeConnections.add(connection);
            }
        }

        return freeConnections;
    }

    //
    public @NotNull List<@NotNull ModuleConnection> getOccupiedConnections(boolean getStructuralConnections) {
        @NotNull List<@NotNull ModuleConnection> occupiedConnections = new ArrayList<>();
        for (@NotNull ModuleConnection connection : connections) {
            @Nullable ModuleConnection tetheredConnection = connection.getTetheredConnection();
            if (tetheredConnection != null && (!getStructuralConnections || (!connection.getIsParentConnection() &&
                    tetheredConnection.getParentModule() instanceof StructuralModule))) {
                occupiedConnections.add(connection);
            }
        }
        return occupiedConnections;
    }

}