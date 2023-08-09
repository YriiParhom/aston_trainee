package serviseonservletsjdbc.repository;

import serviseonservletsjdbc.dto.CustomerResponse;
import serviseonservletsjdbc.dto.OrderResponse;
import serviseonservletsjdbc.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl extends JDBCUtil implements OrderRepository{

    private final String INSERT_INTO_TABLE = "insert into orders(order_name, price, customer_id)" +
            "values (?, ?, ?)";

    private final String DELETE_ORDER_BY_ID = "delete from orders where id = ?";

    private final String FIND_ORDER_BY_ID =
            "select * from orders left join customer c on orders.customer_id = c.id where orders.id = ? ";

    private static final String FIND_ALL_ORDERS =
            "select * from orders left join customer c on orders.customer_id = c.id";


    @Override
    public void saveOrder(Order orderRequest)  {

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT_INTO_TABLE)) {

            preparedStatement.setString(1, orderRequest.getName());
            preparedStatement.setDouble(2, orderRequest.getPrice());
            preparedStatement.setLong(3, orderRequest.getOwner());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderById(Long id) {

        try(PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_ORDER_BY_ID)) {

            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderResponse findOrderById(Long id) {

        OrderResponse orderResponse = new OrderResponse();

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_ORDER_BY_ID)) {

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                orderResponse.setId(resultSet.getLong("id"));
                orderResponse.setName(resultSet.getString("order_name"));
                orderResponse.setPrice(resultSet.getDouble("price"));
                orderResponse.setCustomerName(resultSet.getString("customer_name"));
                orderResponse.setCustomerSurname(resultSet.getString("customer_surname"));
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

            ResultSet resultSet = statement.executeQuery(FIND_ALL_ORDERS);

            while(resultSet.next()) {
                orders.add(new OrderResponse(
                        resultSet.getLong("id"),
                        resultSet.getString("order_name"),
                        resultSet.getDouble("price"),
                        resultSet.getString("customer_name"),
                        resultSet.getString("customer_surname")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }
}
