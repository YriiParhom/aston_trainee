package serviseonservletsjdbc.service;

import serviseonservletsjdbc.dto.OrderResponse;
import serviseonservletsjdbc.entity.Order;
import serviseonservletsjdbc.repository.OrderRepository;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveOrder(Order orderRequest) throws SQLException {
        orderRepository.saveOrder(orderRequest);
    }

    @Override
    public void deleteOrderById(long id) {
        orderRepository.deleteOrderById(id);
    }

    @Override
    public OrderResponse findOrderById(long id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public List<OrderResponse> findAllOrders() {
        return orderRepository.findAllOrders();
    }
}
