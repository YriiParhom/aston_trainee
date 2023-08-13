package servicebyservletshibernamte.service;

import servicebyservletshibernamte.dto.CustomerResponse;
import servicebyservletshibernamte.entity.Customer;
import servicebyservletshibernamte.repository.CustomerRepository;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.deleteCustomer(customer);
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findCustomerById(id);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAllCustomers();
    }
}
