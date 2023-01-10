package eu.misi.vehicleentity;

//education: builder in different class
public class OwnerBuilder {
    private String familyName;
    private String lastName;
    private String city;
    private String postalCode;

    private String street;
    private int streetNumber;

    public static OwnerBuilder aBuild() {
        return new OwnerBuilder();
    }

    public Owner build() {
        Owner owner = new Owner();
        owner.familyName = familyName;
        owner.lastName = lastName;
        owner.address = Address.AddressBuilder.aBuild()
                .setCity(city)
                .setPostalCode(postalCode)
                .setStreet(street)
                .setStreetNumber(streetNumber)
                .build();
        return owner;
    }

    public OwnerBuilder setFamilyName(String familyName) {
        this.familyName = familyName;
        return this;
    }

    public OwnerBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public OwnerBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public OwnerBuilder setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public OwnerBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public OwnerBuilder setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }
}
