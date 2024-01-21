package demo;

import baryModel.BaryModel;

import testGraphics.TestWindow;

//
public class Main {
    private static final BaryModel BARY_MODEL;

    static {
        BARY_MODEL = new BaryModel();
    }

    //
    public static void main(String[] args) {
        //TODO: do something here
        startGraphics();
    }

    private static void startGraphics() {
        new TestWindow(BARY_MODEL);
    }
}