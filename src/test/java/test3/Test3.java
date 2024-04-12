package test3;

import org.jetbrains.annotations.NotNull;

import graphicalTestAbstraction.GraphicalTest;
import test3.models.StructuralModule;
import test3.models.TestModule;
import test3.models.Spacecraft;
import test3.player.Player;
import test3.graphics.Window;

//
public class Test3 extends GraphicalTest {
    private static final int STARTING_MONEY = 1000;

    //
    public static void main(String[] args) {
        new Test3(new Player(STARTING_MONEY));
    }

    //
    private Test3(@NotNull Player player) {
        super(new Window(player));
        addInitialShipParts(player);
        addInitialShips(player);
    }

    private void addInitialShipParts(@NotNull Player player) {
        //adds 2 structural modules
        player.addShipPart(new StructuralModule());
        player.addShipPart(new StructuralModule());

        //adds 3 test modules
        player.addShipPart(new TestModule());
        player.addShipPart(new TestModule());
        player.addShipPart(new TestModule());

        //adds 2 more structural modules
        player.addShipPart(new StructuralModule());
        player.addShipPart(new StructuralModule());
    }

    private void addInitialShips(@NotNull Player player) {
        //adds 2 ships
        player.addShip(new Spacecraft("Ship 1", new StructuralModule()));
        player.addShip(new Spacecraft("Ship 2", new StructuralModule()));
    }
}