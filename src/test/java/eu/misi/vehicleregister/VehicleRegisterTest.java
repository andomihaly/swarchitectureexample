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
        VehicleRegister vehicleRegister = new VehicleRegister(spyVehicleStorage, null);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reqistrationNumber","AABB124");
        vehicleRegister.createNewCar(jsonObject.toString());

        Assertions.assertEquals("AABB124", spyVehicleStorage.vehicle.registrationNumber);
    }

    @Test
    void catchAllExceptionInApiCallTest() {
        VehicleStorage vehicleStorage = new NotWorkingVehicleStorage();
        SpyVehicleRegisterDisplay spyVehicleRegisterDisplay = new SpyVehicleRegisterDisplay();
        VehicleRegister vehicleRegister = new VehicleRegister(vehicleStorage, spyVehicleRegisterDisplay);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("reqistrationNumber","AABB124");

        Assertions.assertDoesNotThrow(()-> vehicleRegister.createNewCar(jsonObject.toString()));
        Assertions.assertEquals("vehicle storage is not working", spyVehicleRegisterDisplay.errorJson.getString("message"));
    }

    private class SpyVehicleStorage implements VehicleStorage {
        public Vehicle vehicle;

        @Override
        public void saveVehicle(Vehicle vehicle) {
            this.vehicle=vehicle;
        }

    }

    private class  NotWorkingVehicleStorage implements VehicleStorage {
        @Override
        public void saveVehicle(Vehicle vehicle) {
            throw new RuntimeException("vehicle storage is not working");
        }
    }

    private class SpyVehicleRegisterDisplay implements VehicleRegisterDisplay{
        public JSONObject errorJson;
        @Override
        public void displayError(String json) {
            errorJson = new JSONObject(json);
        }
    }
}
