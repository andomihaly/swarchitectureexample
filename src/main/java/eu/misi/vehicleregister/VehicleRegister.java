package eu.misi.vehicleregister;

import eu.misi.vehicleEntity.Vehicle;
import org.json.JSONObject;
import org.slf4j.MDC;

import java.util.UUID;

public class VehicleRegister {
    private VehicleStorage vehicleStorage;
    public VehicleRegister(VehicleStorage vehicleStorage) {
        this.vehicleStorage = vehicleStorage;
    }

    public void createNewCar(String json) {
        createNewCarAPI(json);
    }

    private void createNewCarAPI(String json) {
        //getBusinessEvent
        //validate
        //parse
        JSONObject jsonObject = new JSONObject(json);
        Vehicle vehicle = new Vehicle();
        vehicle.registrationNumber=jsonObject.getString("reqistrationNumber");
        vehicleStorage.saveVehicle(vehicle);
    }
}
