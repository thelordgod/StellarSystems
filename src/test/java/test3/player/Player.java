package test3.player;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

import test3.models.*;

import static consoleUtils.SimplePrinting.printLine;

//
public class Player {
    private final @NotNull Wallet wallet;
    private final @NotNull List<@NotNull Spacecraft> ownedShips;
    private final @NotNull List<@NotNull SpacecraftModule> shipPartInventory;
    private @NotNull PaintMode paintMode; // for graphical purposes
    private @NotNull ShipyardMode shipyardMode; // for graphical purposes
    private int selectedPartIndex; // for shipyard purposes

    //
    public Player(int money) {
        wallet = new Wallet(money);
        ownedShips = new ArrayList<>();
        shipPartInventory = new ArrayList<>();
        paintMode = PaintMode.SHIPYARD;
        shipyardMode = ShipyardMode.CREATE_SHIP;
    }

    public @NotNull Wallet getWallet() {
        return wallet;
    }

    //
    public @NotNull List<@NotNull Spacecraft> getOwnedShips() {
        return ownedShips;
    }

    //
    public void addShip(@NotNull Spacecraft ship) {
        ownedShips.add(ship);
    }

    //
    public @NotNull List<@NotNull SpacecraftModule> getShipPartInventory() {
        return shipPartInventory;
    }

    //
    public void addShipPart(@NotNull SpacecraftModule part) {
        shipPartInventory.add(part);
    }

    //
    public void createNewShip(int partInventoryIndex) throws WrongModuleTypeException {
        try {
            @NotNull SpacecraftModule part = shipPartInventory.get(partInventoryIndex);
            if (part instanceof StructuralModule core) {
                addShip(new Spacecraft("New ship", core));
                shipPartInventory.remove(partInventoryIndex);
            } else {
                throw new WrongModuleTypeException();
            }
        } catch (@NotNull IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    //
    public void addPartToConnection(@NotNull ModuleConnection connection, int partInventoryIndex) {
        try {
            @NotNull SpacecraftModule part = shipPartInventory.get(partInventoryIndex);
            connection.setTetheredConnection(part);
            shipPartInventory.remove(partInventoryIndex);
        } catch (@NotNull IndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    // for graphical purposes
    public final @NotNull PaintMode getPaintMode() {
        return paintMode;
    }

    // for graphical purposes
    public final @NotNull ShipyardMode getShipyardMode() {
        return shipyardMode;
    }

    // for graphical purposes
    public void setPaintMode(@NotNull PaintMode paintMode) {
        this.paintMode = paintMode;
    }

    // for graphical purposes
    public void setShipyardMode(@NotNull ShipyardMode shipyardMode) {
        printLine("Shipyard mode set to " + shipyardMode.toString());
        this.shipyardMode = shipyardMode;
    }
}