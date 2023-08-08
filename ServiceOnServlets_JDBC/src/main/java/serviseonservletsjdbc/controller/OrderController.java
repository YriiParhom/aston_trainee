package serviseonservletsjdbc.controller;

import com.google.gson.Gson;
import serviseonservletsjdbc.dto.OrderResponse;
import serviseonservletsjdbc.entity.Order;
import serviseonservletsjdbc.service.OrderService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

public class OrderController {

    public final String APPLICATION_JSON = "application/json";

    private final OrderService orderService;

    private final Gson gson;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        this.gson = new Gson();
    }

    public void saveOrder(Reader body, HttpServletResponse response) throws SQLException, IOException {

        response.setContentType(APPLICATION_JSON);
        Order order = gson.fromJson(body, Order.class);
        orderService.saveOrder(order);
        response.getWriter().print("Order created!");
    }

    public void deleteOrderById(Long id, HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        orderService.deleteOrderById(id);
        response.getWriter().print("Delete completed!");
    }

    public void findOrderById(Long id, HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        OrderResponse order = orderService.findOrderById(id);
        response.getWriter().print(gson.toJson(order));
    }

    public void findAllOrders(HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        List<OrderResponse> orders = orderService.findAllOrders();
        response.getWriter().print(gson.toJson(orders));
    }
}
