package serviseonservletsjdbc.repository;

import serviseonservletsjdbc.dto.CustomerResponse;
import serviseonservletsjdbc.dto.OrderResponse;
import serviseonservletsjdbc.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl extends JDBCUtil implements OrderRepository{

    private final String INSERT_INTO_TABLE = "insert into orders(name, price, date, customer_id)" +
            "values (?, ?, ?, ?)";
    private final String DELETE_ORDER_BY_ID = "delete from orders where id = ?";
    private final String FIND_ORDER_BY_ID =
            "select * from orders left join customer c on orders.customer_id = c.id where orders.id = ? ";


    @Override
    public void saveOrder(Order orderRequest)  {

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_INTO_TABLE)) {

            preparedStatement.setString(1, orderRequest.getName());
            preparedStatement.setDouble(2, orderRequest.getPrice());
            preparedStatement.setDate(3, (Date) orderRequest.getDate());
            preparedStatement.setLong(4, orderRequest.getCustomerId());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderById(long id) {

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_ORDER_BY_ID)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderResponse findOrderById(long id) {

        OrderResponse orderResponse = new OrderResponse();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_ORDER_BY_ID)) {

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                orderResponse.setId(resultSet.getLong("id"));
                orderResponse.setName(resultSet.getString("name"));
                orderResponse.setPrice(resultSet.getDouble("price"));
                orderResponse.setDate(resultSet.getDate("date"));
                orderResponse.setCustomerName(resultSet.getString("name"));
                orderResponse.setCustomerSurname(resultSet.getString("surname"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderResponse;
    }

    @Override
    public List<OrderResponse> findAllOrders() {

        List<OrderResponse> orders = new ArrayList<>();

        try(Statement statement = getConnection().createStatement()) {

            ResultSet resultSet = statement.getResultSet();

            while(resultSet.next()) {
                orders.add(new OrderResponse(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price"),
                        resultSet.getDate("date"),
                        resultSet.getString("name"),
                        resultSet.getString("surname")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}
