package serviseonservletsjdbc.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer customer;

    @BeforeEach
    void setup() {
        customer = new Customer();
        customer.setId(1L);
        customer.setName("Ivan");
        customer.setSurname("Ivanov");
    }

    @Test
    void setId() {
        assertEquals(1L, customer.getId());
    }

    @Test
    void setName() {
        assertEquals("Ivan", customer.getName());
    }

    @Test
    void setSurname() {
        assertEquals("Ivanov", customer.getSurname());
    }

    @Test
    void getId() {
        assertEquals(customer.getId(), 1L);
    }

    @Test
    void getName() {
        assertEquals(customer.getName(), "Ivan");
    }

    @Test
    void getSurname() {
        assertEquals(customer.getSurname(), "Ivanov");
    }
}