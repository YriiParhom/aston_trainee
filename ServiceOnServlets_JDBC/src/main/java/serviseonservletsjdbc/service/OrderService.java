package serviseonservletsjdbc.service;

import serviseonservletsjdbc.dto.OrderResponse;
import serviseonservletsjdbc.entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    void saveOrder(Order orderRequest) throws SQLException;

    void deleteOrderById(long id);

    OrderResponse findOrderById(long id);

    List<OrderResponse> findAllOrders();
}
