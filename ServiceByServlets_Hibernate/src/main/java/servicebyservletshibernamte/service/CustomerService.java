package servicebyservletshibernamte.service;

import servicebyservletshibernamte.dto.CustomerResponse;
import servicebyservletshibernamte.entity.Customer;

import java.util.List;

public interface CustomerService {

    void addCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer findCustomerById(Long id);

    List<Customer> findAllCustomers();
}
