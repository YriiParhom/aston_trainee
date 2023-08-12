package serviseonservletsjdbc.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import serviseonservletsjdbc.dto.CustomerResponse;
import serviseonservletsjdbc.entity.Customer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryImplTest {

    CustomerRepositoryImpl customerRepository;

    @BeforeEach
    void setup() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @Test
    void saveUser() {

        Customer customer = new Customer(1L, "Ivan", "Ivanov");
        customerRepository.saveCustomer(customer);

        List<CustomerResponse> customers = customerRepository.findAllCustomers();
        assertNotNull(customers);
        assertEquals(1, customers.size());

        customerRepository.deleteCustomerById(1);
    }
}