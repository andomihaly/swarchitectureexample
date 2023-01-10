package eu.misi.vehicleregister;


import eu.misi.vehicleEntity.VehicleColour;
import eu.misi.vehicleEntity.VehicleMotorEmissionType;
import eu.misi.vehicleEntity.VehicleType;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class NewVehicleDTOParser {
    public static NewVehicleDTO parse(String json) {
        Map<String, VehicleMotorEmissionType> emissionMap = new HashMap<String, VehicleMotorEmissionType>();
        for (int i=0; i<VehicleMotorEmissionType.values().length; i++){
            emissionMap.put("e"+i, VehicleMotorEmissionType.valueOf("Euro"+i));
        }

        JSONObject inputData = new JSONObject(json);
        NewVehicleDTO vehicleDTO = new NewVehicleDTO();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");


        vehicleDTO.carType = VehicleType.valueOf(inputData.getString("carType"));
        vehicleDTO.registrationNumber = inputData.getString("registrationNumber");
        vehicleDTO.carFirstRegistrationDate = LocalDate.parse(inputData.getString("carFirstRegistrationDate"),formatter);
        vehicleDTO.carMaker=inputData.getString("carMaker");
        vehicleDTO.carModel=inputData.getString("carModel");
        vehicleDTO.carColour = VehicleColour.valueOf(inputData.getString("carColour"));
        vehicleDTO.carEngineNumber = inputData.getString("carEngineNumber");
        vehicleDTO.carNumberOfSeats = inputData.getInt("carNumberOfSeats");
        vehicleDTO.carMassInService = inputData.getInt("carMassInService");
        vehicleDTO.carMaxMass = inputData.getInt("carMaxMass");
        vehicleDTO.carBrakedTrailer = inputData.getInt("carBrakedTrailer");
        vehicleDTO.carUnBrakedTrailer = inputData.getInt("carUnBrakedTrailer");
        vehicleDTO.carMotorEmissionType = emissionMap.get(inputData.getString("carMotorEmissionType"));
        vehicleDTO.ownerFamilyName = inputData.getString("ownerFamilyName");
        vehicleDTO.ownerLastName = inputData.getString("ownerLastName");
        vehicleDTO.ownerCity = inputData.getString("ownerCity");
        vehicleDTO.ownerPostalCode = inputData.getString("ownerPostalCode");
        vehicleDTO.ownerStreet = inputData.getString("ownerStreet");
        vehicleDTO.ownerStreetNumber = inputData.getInt("ownerStreetNumber");

        return vehicleDTO;
    }
}
