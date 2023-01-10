package eu.misi.vehicleregister;

import java.time.LocalDate;

public class Vehicle {
    public VehicleType type;
    public String registrationNumber;
    public LocalDate firstRegistrationDate;
    public String make;
    public String model;
    public VehicleColour colour;
    public String engineNumber;

    public int numberOfSeeats;
    public int massInService;
    public int maxMass;
    public int brakedTrailer;
    public int unBreakedTrailer;
    public VehicleMotorEmissionType motorEmissionType;
    public Owner owner;
}
