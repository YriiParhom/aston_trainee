package serviseonservletsjdbc.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerResponseTest {

    CustomerResponse customerResponse;

    @BeforeEach
    void setup() {
        customerResponse = new CustomerResponse();
        customerResponse.setId(3L);
        customerResponse.setName("Alexander");
        customerResponse.setSurname("Shpack");
    }

    @Test
    void setId() {
        assertEquals(3L, customerResponse.getId());
    }

    @Test
    void setName() {
        assertEquals("Alexander", customerResponse.getName());
    }

    @Test
    void setSurname() {
        assertEquals("Shpack", customerResponse.getSurname());
    }

    @Test
    void getId() {
        assertEquals(customerResponse.getId(), 3L);
    }

    @Test
    void getName() {
        assertEquals(customerResponse.getName(), "Alexander");
    }

    @Test
    void getSurname() {
        assertEquals(customerResponse.getSurname(), "Shpack");
    }
}