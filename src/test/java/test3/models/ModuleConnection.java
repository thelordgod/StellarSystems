package test3.models;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ModuleConnection {
    private final @NotNull SpacecraftModule parentModule;
    private @Nullable ModuleConnection tetheredConnection;
    private boolean isParentConnection;
    private final int @NotNull [] location;
    private final double orientation;

    public ModuleConnection(@NotNull SpacecraftModule parentModule, int @NotNull [] location, double orientation) {
        this.parentModule = parentModule;
        this.tetheredConnection = null;
        this.isParentConnection = false;
        this.location = location;
        this.orientation = orientation;
    }

    public @NotNull SpacecraftModule getParentModule() {
        return parentModule;
    }

    public boolean getIsParentConnection() {
        return isParentConnection;
    }

    public void setIsParentConnection(boolean isParentConnection) {
        this.isParentConnection = isParentConnection;
    }

    public void setTetheredConnection(@Nullable ModuleConnection tetheredConnection) {
        this.tetheredConnection = tetheredConnection;
    }

    public @Nullable ModuleConnection getTetheredConnection() {
        return tetheredConnection;
    }

    public int @NotNull [] getLocation() {
        return location;
    }
}