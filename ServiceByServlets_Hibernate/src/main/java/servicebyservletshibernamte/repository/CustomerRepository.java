package servicebyservletshibernamte.repository;

import servicebyservletshibernamte.dto.CustomerResponse;
import servicebyservletshibernamte.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    void addCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer findCustomerById(Long id);

    List<Customer> findAllCustomers();
}
