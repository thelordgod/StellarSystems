package test3.player;

import org.jetbrains.annotations.NotNull;

//
public class Player {
    private PaintMode paintMode;

    //
    public Player() {
        paintMode = PaintMode.SHIPYARD;
    }

    //
    public final @NotNull PaintMode getPaintMode() {
        return paintMode;
    }

    //
    public void setPaintMode(PaintMode paintMode) {
        this.paintMode = paintMode;
    }
}