package test3.graphics;

import org.jetbrains.annotations.NotNull;

import commonGraphics.AbstractKeyListener;
import test3.player.PaintMode;
import test3.player.Player;

//
public final class MyKeyListener extends AbstractKeyListener {
    private final @NotNull Player player;

    //
    public MyKeyListener(@NotNull Player player) {
        super();
        this.player = player;
    }

    //
    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    @Override
    public void keyActionSwitch_byCode(int keyCode) throws UndefinedKeyActionException {
        switch (keyCode) {
            //check keys by keyCode here
            default -> throw new UndefinedKeyActionException();
        }
    }

    //
    @Override
    public void keyActionSwitch_byText(@NotNull String keyText) throws UndefinedKeyActionException {
        switch (keyText) {
            case "1" -> player.setPaintMode(PaintMode.FLIGHT);
            case "2" -> player.setPaintMode(PaintMode.SHIPYARD);
            case "3" -> player.setPaintMode(PaintMode.MISSIONS);
            default -> throw new UndefinedKeyActionException();
        }
    }
}