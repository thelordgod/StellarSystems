package playerTest.models.engines;

import java.util.List;

//initially a ship?
public class Vehicle {
    VehicleInformation information;
    VehicleExterior exterior;
    VehicleInterior interior;

    Vehicle() {
        //
    }
}

class VehicleInformation {
    String name;
    //owner, affiliation, price, history, etc
}

class VehicleExterior {
    //
    void getSize() {}
}

class VehicleInterior {
    List<VehicleRoom> rooms;
}

class VehicleRoom {
    //
}