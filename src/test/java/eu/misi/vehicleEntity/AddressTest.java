package eu.misi.vehicleEntity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AddressTest {
    @Test
    void createAddress() {
        Address address = Address.AddressBuilder.aBuild().setCity("City").
                setPostalCode("PostalCode").
                setStreet("Street").
                setStreetNumber(10).build();
        assertNotNull(address);
        assertEquals("City", address.city);
        assertEquals("PostalCode", address.postalCode);
        assertEquals("Street", address.street);
        assertEquals(10, address.streetNumber);
    }

}