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
    private static final @NotNull Player PLAYER = new Player(STARTING_MONEY);

    //
    public static void main(String[] args) {
        //adds 2 structural modules
        PLAYER.addShipPart(new StructuralModule());
        PLAYER.addShipPart(new StructuralModule());

        //adds 3 test modules
        PLAYER.addShipPart(new TestModule());
        PLAYER.addShipPart(new TestModule());
        PLAYER.addShipPart(new TestModule());

        //adds 2 ships
        PLAYER.addShip(new Spacecraft("Ship 1", new StructuralModule()));
        PLAYER.addShip(new Spacecraft("Ship 2", new StructuralModule()));

        //creates the player with some starting money
        new Test3(PLAYER);
    }

    //
    private Test3(@NotNull Player player) {
        super(new Window(player));
    }
}