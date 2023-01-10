package eu.misi.vehicleregister;


import eu.misi.vehicleEntity.VehicleColour;
import eu.misi.vehicleEntity.VehicleMotorEmissionType;
import eu.misi.vehicleEntity.VehicleType;

import java.time.LocalDate;

public class NewVehicleDTO {
    public VehicleType carType;
    public String registrationNumber;
    public LocalDate carFirstRegistrationDate;
    public String carMaker;
    public String carModel;
    public VehicleColour carColour;
    public String carEngineNumber;
    public int carNumberOfSeats;
    public int carMassInService;
    public int carMaxMass;
    public int carBrakedTrailer;
    public int carUnBrakedTrailer;
    public VehicleMotorEmissionType carMotorEmissionType;
    public String ownerFamilyName;
    public String ownerLastName;
    public String ownerCity;
    public String ownerPostalCode;
    public String ownerStreet;
    public int ownerStreetNumber;
}
