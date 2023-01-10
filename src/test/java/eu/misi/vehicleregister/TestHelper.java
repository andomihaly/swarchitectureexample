package eu.misi.vehicleregister;

import org.json.JSONObject;

public class TestHelper {
    public static JSONObject getValidInputForNewVehicleRegistration() {
        JSONObject inputData = new JSONObject();
        inputData.put("carType", "m1");
        inputData.put("registrationNumber", "regNumber");
        inputData.put("carFirstRegistrationDate", "2022.05.20");
        inputData.put("carMaker", "carMaker");
        inputData.put("carModel", "carModel");
        inputData.put("carColour", "green");
        inputData.put("carEngineNumber", "carEngineNumber");
        inputData.put("carNumberOfSeats", "5");
        inputData.put("carMassInService", "1");
        inputData.put("carMaxMass", "2");
        inputData.put("carBrakedTrailer", "3");
        inputData.put("carUnBrakedTrailer", "4");
        inputData.put("carMotorEmissionType", "e1");
        inputData.put("ownerFamilyName", "ownerFamilyName");
        inputData.put("ownerLastName", "ownerLastName");
        inputData.put("ownerCity", "ownerCity");
        inputData.put("ownerPostalCode", "ownerPostalCode");
        inputData.put("ownerStreet", "ownerStreet");
        inputData.put("ownerStreetNumber", "6");
        return inputData;
    }
}
