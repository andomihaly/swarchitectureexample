package eu.misi.vehicleregister;

import eu.misi.vehicleEntity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VehicleManagerTest {
    @Test
    void createNewVehicleTest() {
        VehicleManager vehicleManeger = new VehicleManager();
        String registrationNumber = "AABB123";
        LocalDate registrationDate = LocalDate.of(2022, 10, 13);
        String make = "CarMake";
        String model = "CarModel";
        VehicleColour vehicleColour = VehicleColour.green;
        String engineNumber = "CM12311213";
        int numberOfSeeats = 5;
        int massInService = 1500;
        int maxMass = 2000;
        int brakedTrailer = 1450;
        int unBreakedTrailer = 750;
        VehicleMotorEmissionType vehicleMotorEmissionType = VehicleMotorEmissionType.Euro0;
        Owner owner = OwnerBuilder.aBuild().build();

        Vehicle vehicle = vehicleManeger.createNewVehicle(VehicleType.m1, registrationNumber, registrationDate, make, model, vehicleColour, engineNumber, numberOfSeeats, massInService, maxMass, brakedTrailer, unBreakedTrailer, vehicleMotorEmissionType, owner);

        Assertions.assertNotNull(vehicle);
        assertEquals(VehicleType.m1, vehicle.type);
        assertEquals(registrationNumber, vehicle.registrationNumber);
        assertEquals(registrationDate.toString(), vehicle.firstRegistrationDate.toString());
        assertEquals(make, vehicle.make);
        assertEquals(model, vehicle.model);
        assertEquals(vehicleColour, vehicle.colour);
        assertEquals(engineNumber, vehicle.engineNumber);
        assertEquals(numberOfSeeats, vehicle.numberOfSeats);
        assertEquals(massInService, vehicle.massInService);
        assertEquals(maxMass, vehicle.maxMass);
        assertEquals(brakedTrailer, vehicle.brakedTrailer);
        assertEquals(unBreakedTrailer, vehicle.unBrakedTrailer);
        assertNotNull(vehicle.owner);
    }
}
