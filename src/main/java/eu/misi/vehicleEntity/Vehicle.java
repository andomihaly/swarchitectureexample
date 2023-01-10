package eu.misi.vehicleEntity;

import java.time.LocalDate;

public class Vehicle {
    public VehicleType type;
    public String registrationNumber;
    public LocalDate firstRegistrationDate;
    public String make;
    public String model;
    public VehicleColour colour;
    public String engineNumber;
    public int numberOfSeats;
    public int massInService;
    public int maxMass;
    public int brakedTrailer;
    public int unBrakedTrailer;
    public VehicleMotorEmissionType motorEmissionType;
    public Owner owner;
}
