package builderTests;

import Ilya_S.patterns.builder.Address;
import Ilya_S.patterns.builder.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BuilderTests {

    @Test
    void builderTest() {
        Address address = Address.builder()
                .street("123 Main St")
                .city("Anytown")
                .state("CA")
                .zip("12345")
                .build();
        User user = User.builder()
                .name("John Doe")
                .age(30)
                .email("john.doe@example.com")
                .address(address)
                .build();

        assertNotNull(user);
        assertEquals("John Doe", user.getName());
    }

    @Test
    void builderUpdateTest() {
        Address address = Address.builder()
                .street("123 Main St")
                .city("Anytown")
                .state("CA")
                .zip("12345")
                .build();
        User initialUser = User.builder()
                .name("John Doe")
                .age(30)
                .email("john.doe@example.com")
                .address(address)
                .build();
        User anotherUser = initialUser.toBuilder()
                .name("Jane Doe")
                .age(25)
                .email("jane.doe@example.com")
                .build();

        assertNotNull(anotherUser);
        assertEquals("Jane Doe", anotherUser.getName());
        assertEquals(25, anotherUser.getAge());
    }
}
