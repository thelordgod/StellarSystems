package test3;

import org.jetbrains.annotations.NotNull;

import graphicalTestAbstraction.GraphicalTest;
import test3.player.Player;
import test3.graphics.Window;

//
public class Test3 extends GraphicalTest {
    private static final @NotNull Player PLAYER = new Player();

    //
    public static void main(String[] args) {
        new Test3(PLAYER);
    }

    //
    private Test3(@NotNull Player player) {
        super(new Window(player));
    }
}