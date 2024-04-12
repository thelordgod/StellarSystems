package test3;

import graphicalTestAbstraction.GraphicalTest;
import test3.graphics.Window;

//
public class Test3 extends GraphicalTest {
    //
    public static void main(String[] args) {
        new Test3();
    }

    //
    private Test3() {
        super(new Window());
    }
}