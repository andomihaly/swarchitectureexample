package eu.misi.vehicleregister;

import eu.misi.vehicleEntity.*;

import java.time.LocalDate;

public class VehicleManager {

    //education: without builder
    public Vehicle createNewVehicle(VehicleType vehicleType, String registrationNumber, LocalDate registrationDate, String make, String model, VehicleColour vehicleColour, String engineNumber, int numberOfSeeats, int massInService, int maxMass, int brakedTrailer, int unBreakedTrailer, VehicleMotorEmissionType vehicleMotorEmissionType, Owner owner) {
        Vehicle vehicle = new Vehicle();
        vehicle.type = vehicleType;
        vehicle.registrationNumber = registrationNumber;
        vehicle.firstRegistrationDate = registrationDate;
        vehicle.make = make;
        vehicle.model = model;
        vehicle.colour = vehicleColour;
        vehicle.engineNumber = engineNumber;
        vehicle.numberOfSeeats = numberOfSeeats;
        vehicle.massInService = massInService;
        vehicle.maxMass = maxMass;
        vehicle.brakedTrailer = brakedTrailer;
        vehicle.unBreakedTrailer = unBreakedTrailer;
        vehicle.motorEmissionType = vehicleMotorEmissionType;
        vehicle.owner = owner;
        return vehicle;
    }
}
