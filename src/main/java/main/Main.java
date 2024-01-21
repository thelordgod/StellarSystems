package main;

import repres.Output;
import repres.BaryGraphics;

//
public class Main {
    //
    public static void main(String[] args) {
        BaryModel model = new BaryModel();
        new Output();
        BaryGraphics graphics = new BaryGraphics(model);
    }
}