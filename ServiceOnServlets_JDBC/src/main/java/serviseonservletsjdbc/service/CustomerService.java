package serviseonservletsjdbc.service;

import serviseonservletsjdbc.dto.CustomerResponse;
import serviseonservletsjdbc.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

    void saveUser(Customer userRequest) throws SQLException;

    void deleteUserById(long id);

    CustomerResponse findUserById(long id);

    List<CustomerResponse> findAllUsers();
}
