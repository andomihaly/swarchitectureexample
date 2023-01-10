package eu.misi.vehicleregister;

import eu.misi.vehicleentity.VehicleColour;
import eu.misi.vehicleentity.VehicleMotorEmissionType;
import eu.misi.vehicleentity.VehicleType;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


class NewVehicleDTOParserTest {

    private JSONObject inputData;

    private static void assertJSON(NewVehicleDTO newVehicleDTO) {
        assertEquals(VehicleType.m1, newVehicleDTO.carType);
        assertEquals("regNumber", newVehicleDTO.registrationNumber);
        assertEquals(LocalDate.of(2022, 05, 20), newVehicleDTO.carFirstRegistrationDate);
        assertEquals("carMaker", newVehicleDTO.carMaker);
        assertEquals("carModel", newVehicleDTO.carModel);
        assertEquals(VehicleColour.green, newVehicleDTO.carColour);
        assertEquals("carEngineNumber", newVehicleDTO.carEngineNumber);
        assertEquals(5, newVehicleDTO.carNumberOfSeats);
        assertEquals(1, newVehicleDTO.carMassInService);
        assertEquals(2, newVehicleDTO.carMaxMass);
        assertEquals(3, newVehicleDTO.carBrakedTrailer);
        assertEquals(4, newVehicleDTO.carUnBrakedTrailer);
        assertEquals(VehicleMotorEmissionType.Euro1, newVehicleDTO.carMotorEmissionType);
        assertEquals("ownerFamilyName", newVehicleDTO.ownerFamilyName);
        assertEquals("ownerLastName", newVehicleDTO.ownerLastName);
        assertEquals("ownerCity", newVehicleDTO.ownerCity);
        assertEquals("ownerPostalCode", newVehicleDTO.ownerPostalCode);
        assertEquals("ownerStreet", newVehicleDTO.ownerStreet);
        assertEquals(6, newVehicleDTO.ownerStreetNumber);
    }

    @BeforeEach
    void setUp() {
        inputData = TestHelper.getValidInputForNewVehicleRegistration();
    }

    @Test
    void parseAVehicle() {
        NewVehicleDTO newVehicleDTO = NewVehicleDTOParser.parse(inputData.toString());

        assertJSON(newVehicleDTO);

    }

    @Test
    void parseVehicleEmission0() {
        inputData.put("carMotorEmissionType", "e0");
        NewVehicleDTO newVehicleDTO = NewVehicleDTOParser.parse(inputData.toString());
        assertEquals(VehicleMotorEmissionType.Euro0, newVehicleDTO.carMotorEmissionType);
    }

    @Test
    void parseVehicleEmission1() {
        inputData.put("carMotorEmissionType", "e1");
        NewVehicleDTO newVehicleDTO = NewVehicleDTOParser.parse(inputData.toString());
        assertEquals(VehicleMotorEmissionType.Euro1, newVehicleDTO.carMotorEmissionType);
    }

    @Test
    void parseVehicleEmission2() {
        inputData.put("carMotorEmissionType", "e2");
        NewVehicleDTO newVehicleDTO = NewVehicleDTOParser.parse(inputData.toString());
        assertEquals(VehicleMotorEmissionType.Euro2, newVehicleDTO.carMotorEmissionType);
    }

    @Test
    void parseVehicleEmission3() {
        inputData.put("carMotorEmissionType", "e3");
        NewVehicleDTO newVehicleDTO = NewVehicleDTOParser.parse(inputData.toString());
        assertEquals(VehicleMotorEmissionType.Euro3, newVehicleDTO.carMotorEmissionType);
    }

    @Test
    void parseVehicleEmission4() {
        inputData.put("carMotorEmissionType", "e4");
        NewVehicleDTO newVehicleDTO = NewVehicleDTOParser.parse(inputData.toString());
        assertEquals(VehicleMotorEmissionType.Euro4, newVehicleDTO.carMotorEmissionType);
    }

    @Test
    void parseVehicleEmission5() {
        inputData.put("carMotorEmissionType", "e5");
        NewVehicleDTO newVehicleDTO = NewVehicleDTOParser.parse(inputData.toString());
        assertEquals(VehicleMotorEmissionType.Euro5, newVehicleDTO.carMotorEmissionType);
    }

    @Test
    void parseVehicleEmission6() {
        inputData.put("carMotorEmissionType", "e6");
        NewVehicleDTO newVehicleDTO = NewVehicleDTOParser.parse(inputData.toString());
        assertEquals(VehicleMotorEmissionType.Euro6, newVehicleDTO.carMotorEmissionType);
    }

}