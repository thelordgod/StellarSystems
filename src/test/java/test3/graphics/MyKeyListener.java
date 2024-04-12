package test3.graphics;

import org.jetbrains.annotations.NotNull;

import static consoleUtils.SimplePrinting.printLine;

import commonGraphics.AbstractKeyListener;
import test3.player.PaintMode;
import test3.player.Player;
import test3.player.ShipyardMode;

//
final class MyKeyListener extends AbstractKeyListener {
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
            case "F1" -> player.setPaintMode(PaintMode.FLIGHT);
            case "F2" -> player.setPaintMode(PaintMode.SHIPYARD);
            case "F3" -> player.setPaintMode(PaintMode.MISSIONS);
            //check more universal keys here
            default -> {
                switch (player.getPaintMode()) {
                    case FLIGHT -> keyActionSwitch_byText_FlightMode(keyText);
                    case SHIPYARD -> keyActionSwitch_byText_ShipyardMode(keyText);
                    case MISSIONS -> keyActionSwitch_byText_MissionsMode(keyText);
                    default -> throw new UndefinedKeyActionException();
                }
            }
        }
    }

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    private void keyActionSwitch_byText_FlightMode(@NotNull String keyText) throws UndefinedKeyActionException {
        switch (keyText) {
            case "Space" -> printLine("A space bar has been pressed!");
            //check more flight-specific keys here
            default -> throw new UndefinedKeyActionException();
        }
    }

    private void keyActionSwitch_byText_ShipyardMode(@NotNull String keyText) throws UndefinedKeyActionException {
        switch (keyText) {
            case "1" -> player.setShipyardMode(ShipyardMode.CREATE_SHIP);
            case "2" -> player.setShipyardMode(ShipyardMode.ADD_MODULE);
            default -> throw new UndefinedKeyActionException();
        }
    }

    @SuppressWarnings("SwitchStatementWithTooFewBranches")
    private void keyActionSwitch_byText_MissionsMode(@NotNull String keyText) throws UndefinedKeyActionException {
        switch (keyText) {
            case "Space" -> printLine("A space bar has been pressed!");
            //check more missions-specific keys here
            default -> throw new UndefinedKeyActionException();
        }
    }
}