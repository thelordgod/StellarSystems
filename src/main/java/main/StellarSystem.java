package main;

import java.util.List;
import java.util.ArrayList;

//unfinished
public class StellarSystem {
    final List<Star> stars;

    StellarSystem(List<Star> stars) {
        this.stars = stars;
    }

    //
    public static class SolarSystem extends StellarSystem {
        SolarSystem() {
            super(new ArrayList<>() {{
                add(new Star.Sun());
            }});
        }
        //
    }

    //
    public static class AlphaCentauriSystem extends StellarSystem {

        AlphaCentauriSystem() {
            super(new ArrayList<>() {{
                add(new Star.RigilKentaurus());
                add(new Star.Toliman());
                add(new Star.ProximaCentauri());
            }});
        }
    }
}

//
class Star {
    final String name;

    Star(String name) {
        this.name = name;
    }

    //
    static class Sun extends Star {
        //
        Sun() {
            super("Sun");
        }
    }

    //Alpha Centauri A
    static class RigilKentaurus extends Star {
        //
        RigilKentaurus() {
            super("Rigil Kentaurus");
        }
    }

    //Alpha Centauri B
    static class Toliman extends Star {
        //
        Toliman() {
            super("Toliman");
        }
    }

    //Alpha Centauri C
    static class ProximaCentauri extends Star {
        //
        ProximaCentauri() {
            super("Proxima Centauri");
        }
    }
}