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
        JSONObject inputData =  TestHelper.getValidInputForNewVehicleRegistration();


        vehicleRegister.createNewCar(inputData.toString());
        Assertions.assertEquals(1, spyVehicleStorage.numberOfSave);

        vehicleRegister.createNewCar(inputData.toString());
        Assertions.assertEquals(2, spyVehicleStorage.numberOfSave);
    }

    @Test
    void catchAllExceptionInApiCallTest() {
        VehicleStorage vehicleStorage = new NotWorkingVehicleStorage();
        SpyVehicleRegisterDisplay spyVehicleRegisterDisplay = new SpyVehicleRegisterDisplay();
        VehicleRegister vehicleRegister = new VehicleRegister(vehicleStorage, spyVehicleRegisterDisplay);

        Assertions.assertDoesNotThrow(()-> vehicleRegister.createNewCar(TestHelper.getValidInputForNewVehicleRegistration().toString()));
        Assertions.assertEquals("vehicle storage is not working", spyVehicleRegisterDisplay.errorJson.getString("message"));
    }

    private class SpyVehicleStorage implements VehicleStorage {
        public int numberOfSave=0;

        @Override
        public void saveVehicle(Vehicle vehicle) {
            numberOfSave++;
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
