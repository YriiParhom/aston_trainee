package serviseonservletsjdbc.repository;

import serviseonservletsjdbc.dto.CustomerResponse;
import serviseonservletsjdbc.entity.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl extends JDBCUtil implements CustomerRepository {

    private final String INSERT_INTO_TABLE = "insert into customer (name, surname) values (?,?)";
    private final String DELETE_BY_ID = "delete from customer where id = ?";
    private final String FIND_CUSTOMER_BY_ID = "select * from customer where id = ?";
    private final String FIND_ALL_CUSTOMERS = "select * from customer";


    public void saveUser(Customer customer) {

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_INTO_TABLE)) {

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurname());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUserById(long id) {

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_BY_ID)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public CustomerResponse findUserById(long id) {

        CustomerResponse customerResponse = new CustomerResponse();

        try (Statement statement = getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(FIND_CUSTOMER_BY_ID);

            while (resultSet.next()) {
                customerResponse.setId(resultSet.getLong("id"));
                customerResponse.setName(resultSet.getString("name"));
                customerResponse.setSurname(resultSet.getString("surname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerResponse;
    }

    public List<CustomerResponse> findAllUsers() {

        List<CustomerResponse> allCustomersWeHave = new ArrayList<>();

        try (Statement statement = getConnection().createStatement()) {

            ResultSet resultSet = statement.executeQuery(FIND_ALL_CUSTOMERS);

            while (resultSet.next()) {

                allCustomersWeHave.add(new CustomerResponse(resultSet.getLong("id"),
                        resultSet.getString("name"), resultSet.getString("surname")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCustomersWeHave;
    }
}
