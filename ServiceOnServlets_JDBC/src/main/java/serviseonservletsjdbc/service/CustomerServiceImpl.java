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
    public void saveUser(Customer userRequest) throws SQLException {
        customerRepository.saveUser(userRequest);
    }

    @Override
    public void deleteUserById(long id) {
        customerRepository.deleteUserById(id);
    }

    @Override
    public CustomerResponse findUserById(long id) {
        return customerRepository.findUserById(id);
    }

    @Override
    public List<CustomerResponse> findAllUsers() {
        return customerRepository.findAllUsers();
    }
}
