package serviseonservletsjdbc.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order order;

    @BeforeEach
    void setup() {
        order = new Order();
        order.setId(2L);
        order.setName("Iphone");
        order.setPrice(150_000.00);
        order.setOwner(1L);
    }

    @Test
    void setId() {
        assertEquals(2L, order.getId());
    }

    @Test
    void setName() {
        assertEquals("Iphone", order.getName());
    }

    @Test
    void setPrice() {
        assertEquals(150_000.00, order.getPrice());
    }

    @Test
    void setOwner() {
        assertEquals(1L, order.getOwner());
    }

    @Test
    void getId() {
        assertEquals(order.getId(), 2L);
    }

    @Test
    void getName() {
        assertEquals(order.getName(), "Iphone");
    }

    @Test
    void getPrice() {
        assertEquals(order.getPrice(), 150_000.00);
    }

    @Test
    void getOwner() {
        assertEquals(order.getOwner(), 1L);
    }
}