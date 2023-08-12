package serviseonservletsjdbc.service;

import serviseonservletsjdbc.dto.CustomerResponse;
import serviseonservletsjdbc.entity.Customer;
import serviseonservletsjdbc.repository.CustomerRepository;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void saveCustomer(Customer userRequest) throws SQLException {
        customerRepository.saveCustomer(userRequest);
    }

    @Override
    public void deleteCustomerById(long id) {
        customerRepository.deleteCustomerById(id);
    }

    @Override
    public CustomerResponse findCustomerById(long id) {
        return customerRepository.findCustomerById(id);
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAllCustomers();
    }
}
