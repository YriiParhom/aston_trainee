package serviseonservletsjdbc.repository;

import serviseonservletsjdbc.dto.CustomerResponse;
import serviseonservletsjdbc.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {

    void saveCustomer(Customer userRequest) throws SQLException;

    void deleteCustomerById(long id);

    CustomerResponse findCustomerById(long id);

    List<CustomerResponse> findAllCustomers();
}
