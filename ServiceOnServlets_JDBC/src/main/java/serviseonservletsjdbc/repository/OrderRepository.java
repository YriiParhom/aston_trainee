package serviseonservletsjdbc.repository;

import serviseonservletsjdbc.dto.CustomerResponse;
import serviseonservletsjdbc.dto.OrderResponse;
import serviseonservletsjdbc.entity.Customer;
import serviseonservletsjdbc.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository {

    void saveOrder(Order orderRequest) throws SQLException;

    void deleteOrderById(Long id);

    OrderResponse findOrderById(Long id);

    List<OrderResponse> findAllOrders();
}
