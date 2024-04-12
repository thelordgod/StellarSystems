package test3.player;

import java.util.List;
import java.util.ArrayList;

import org.jetbrains.annotations.NotNull;

import test3.models.WrongModuleTypeException;
import test3.models.SpacecraftModule;
import test3.models.StructuralModule;
import test3.models.Spacecraft;

//
public class Player {
    private final @NotNull Wallet wallet;
    private final @NotNull List<@NotNull Spacecraft> ownedShips;
    private final @NotNull List<@NotNull SpacecraftModule> shipPartInventory;
    private @NotNull PaintMode paintMode; // for graphical purposes

    //
    public Player(int money) {
        wallet = new Wallet(money);
        ownedShips = new ArrayList<>();
        shipPartInventory = new ArrayList<>();
        paintMode = PaintMode.SHIPYARD;
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

    // for graphical purposes
    public final @NotNull PaintMode getPaintMode() {
        return paintMode;
    }

    // for graphical purposes
    public void setPaintMode(@NotNull PaintMode paintMode) {
        this.paintMode = paintMode;
    }
}