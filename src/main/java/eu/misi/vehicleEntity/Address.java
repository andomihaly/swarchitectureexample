package eu.misi.vehicleEntity;

public class Address {
    public String city;
    public String postalCode;
    public String street;
    public int streetNumber;

    //education: builder in subclass
    public static class AddressBuilder {
        private String city;
        private String postalCode;
        private String street;
        private int streetNumber;

        public static AddressBuilder aBuild() {
            return new AddressBuilder();
        }

        public Address build() {
            Address address = new Address();
            address.city = city;
            address.postalCode = postalCode;
            address.street = street;
            address.streetNumber = streetNumber;
            return address;
        }

        public AddressBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public AddressBuilder setStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder setStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }
    }
}
