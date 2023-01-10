package eu.misi.vehicleregister;

import eu.misi.vehicleEntity.Vehicle;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VehicleRegisterTest {
    @Test
    void createAndSaveVehicleTest() {
        SpyVehicleStorage spyVehicleStorage = new SpyVehicleStorage();
        VehicleRegister vehicleRegister = new VehicleRegister(spyVehicleStorage);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reqistrationNumber","AABB124");
        vehicleRegister.createNewCar(jsonObject.toString());

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
