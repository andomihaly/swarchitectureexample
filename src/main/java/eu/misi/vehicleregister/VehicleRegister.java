package eu.misi.vehicleregister;

import eu.misi.vehicleEntity.Owner;
import eu.misi.vehicleEntity.OwnerBuilder;
import eu.misi.vehicleEntity.Vehicle;
import eu.misi.vehicleEntity.VehicleMotorEmissionType;
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

        NewVehicleDTO newVehicleDTO = NewVehicleDTOParser.parse(json);
        Owner owner = createOwnerFrom(newVehicleDTO);
        Vehicle vehicle = createANewVehicleEntity(newVehicleDTO, owner);
        vehicleStorage.saveVehicle(vehicle);
    }

    private Owner createOwnerFrom(NewVehicleDTO newVehicleDTO) {
        return OwnerBuilder.aBuild()
                .setFamilyName(newVehicleDTO.ownerFamilyName)
                .setLastName(newVehicleDTO.ownerLastName)
                .setCity(newVehicleDTO.ownerCity)
                .setPostalCode(newVehicleDTO.ownerPostalCode)
                .setStreet(newVehicleDTO.ownerStreet)
                .setStreetNumber(newVehicleDTO.ownerStreetNumber)
                .build();
    }

    private Vehicle createANewVehicleEntity(NewVehicleDTO newVehicleDTO, Owner owner) {
        return VehicleManager.createNewVehicle(
                newVehicleDTO.carType,
                newVehicleDTO.registrationNumber,
                newVehicleDTO.carFirstRegistrationDate,
                newVehicleDTO.carEngineNumber,
                newVehicleDTO.carModel,
                newVehicleDTO.carColour,
                newVehicleDTO.carEngineNumber,
                newVehicleDTO.carNumberOfSeats,
                newVehicleDTO.carMassInService,
                newVehicleDTO.carMaxMass,
                newVehicleDTO.carBrakedTrailer,
                newVehicleDTO.carUnBrakedTrailer,
                newVehicleDTO.carMotorEmissionType,
                owner);
    }
}
