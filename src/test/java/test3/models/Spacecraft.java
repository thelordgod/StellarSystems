package test3.models;

import org.jetbrains.annotations.NotNull;

//
@SuppressWarnings("ClassCanBeRecord")
public class Spacecraft {
    private final @NotNull CoreModule core;

    //
    public Spacecraft(@NotNull CoreModule core) {
        this.core = core;
    }

    //
    public @NotNull CoreModule getCore() {
        return core;
    }
}