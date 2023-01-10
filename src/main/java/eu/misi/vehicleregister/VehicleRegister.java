package eu.misi.vehicleregister;

import eu.misi.vehicleEntity.Vehicle;
import org.json.JSONObject;
import org.slf4j.MDC;

import java.util.UUID;

public class VehicleRegister {
    private VehicleStorage vehicleStorage;
    private VehicleRegisterDisplay vehicleRegisterDisplay;
    public VehicleRegister(VehicleStorage vehicleStorage, VehicleRegisterDisplay vehicleRegisterDisplay) {
        this.vehicleStorage = vehicleStorage;
        this.vehicleRegisterDisplay = vehicleRegisterDisplay;
    }

    public void createNewCar(String json) {
        MDC.put("transactionID", UUID.randomUUID().toString());
        try {
            createNewCarAPI(json);
        } catch (Exception e) {
            prepareErrorResponseAndSend(e);
        } finally {
            MDC.put("transactionID", UUID.randomUUID().toString());
        }
    }

    private void prepareErrorResponseAndSend(Exception e) {
        vehicleRegisterDisplay.displayError(createErrorResponse(e).toString());
    }

    private static JSONObject createErrorResponse(Exception e) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", e.getMessage());
        return jsonObject;
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
