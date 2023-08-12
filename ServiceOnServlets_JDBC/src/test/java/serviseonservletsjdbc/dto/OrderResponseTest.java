package serviseonservletsjdbc.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderResponseTest {

    OrderResponse orderResponse;

    @BeforeEach
    void setup() {
        orderResponse = new OrderResponse();
        orderResponse.setId(1L);
        orderResponse.setName("Honda");
        orderResponse.setPrice(300_000.00);
        orderResponse.setCustomerName("Sergey");
        orderResponse.setCustomerSurname("Smirnov");
    }

    @Test
    void setId() {
        assertEquals(1L, orderResponse.getId());
    }

    @Test
    void setName() {
        assertEquals("Honda", orderResponse.getName());
    }

    @Test
    void setPrice() {
        assertEquals(300_000.00, orderResponse.getPrice());
    }

    @Test
    void setCustomerName() {
        assertEquals("Sergey", orderResponse.getCustomerName());
    }

    @Test
    void setCustomerSurname() {
        assertEquals("Smirnov", orderResponse.getCustomerSurname());
    }

    @Test
    void getId() {
        assertEquals(orderResponse.getId(), 1L);
    }

    @Test
    void getName() {
        assertEquals(orderResponse.getName(), "Honda");
    }

    @Test
    void getPrice() {
        assertEquals(orderResponse.getPrice(), 300_000.00);
    }

    @Test
    void getCustomerName() {
        assertEquals(orderResponse.getCustomerName(), "Sergey");
    }

    @Test
    void getCustomerSurname() {
        assertEquals(orderResponse.getCustomerSurname(), "Smirnov");
    }
}