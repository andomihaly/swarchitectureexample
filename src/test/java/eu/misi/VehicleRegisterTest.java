package eu.misi;

import eu.misi.vehicleEntity.Vehicle;
import eu.misi.vehicleregister.TestHelper;
import eu.misi.vehicleregister.VehicleRegister;
import eu.misi.vehicleregister.VehicleRegisterDisplay;
import eu.misi.vehicleregister.VehicleStorage;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VehicleRegisterTest {
    @Test
    void createAndSaveVehicleTest() {
        SpyVehicleStorage spyVehicleStorage = new SpyVehicleStorage();
        VehicleRegister vehicleRegister = new VehicleRegister(spyVehicleStorage, null);
        JSONObject inputData =  TestHelper.getValidInputForNewVehicleRegistration();
        inputData.put("registrationNumber","AABB124");
        vehicleRegister.createNewCar(inputData.toString());

        Assertions.assertEquals("AABB124", spyVehicleStorage.vehicle.registrationNumber);
    }


    private class SpyVehicleStorage implements VehicleStorage {
        public Vehicle vehicle;

        @Override
        public void saveVehicle(Vehicle vehicle) {
            this.vehicle=vehicle;
        }

    }
}
