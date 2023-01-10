package eu.misi.vehicleregister;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerBuilderTest {
    @Test
    void createOwner(){
        Owner owner = OwnerBuilder.aBuild()
                .setFamilyName("FamilyName")
                .setLastName("LastName")
                .setCity("City")
                .setPostalCode("PostalCode")
                .setStreet("Street")
                .setStreetNumber(2)
                .build();
        assertNotNull(owner);
        assertEquals("FamilyName", owner.familyName);
        assertEquals("LastName", owner.lastName);
        assertEquals("City", owner.address.city);
        assertEquals("PostalCode", owner.address.postalCode);
        assertEquals("Street", owner.address.street);
        assertEquals(2, owner.address.streetNumber);
    }

}