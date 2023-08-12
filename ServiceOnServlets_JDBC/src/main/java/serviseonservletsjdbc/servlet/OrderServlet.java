package serviseonservletsjdbc.servlet;

import serviseonservletsjdbc.controller.OrderController;
import serviseonservletsjdbc.repository.OrderRepository;
import serviseonservletsjdbc.repository.OrderRepositoryImpl;
import serviseonservletsjdbc.service.OrderService;
import serviseonservletsjdbc.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class OrderServlet extends HttpServlet {

    private final String API_PATH = "/api/orders";
    private final String API_PATH_WITH_NUMBERS = API_PATH + "/\\d+";
    private OrderController orderController;

    @Override
    public void init() throws ServletException {
        OrderRepository orderRepository = new OrderRepositoryImpl();
        OrderService orderService = new OrderServiceImpl(orderRepository);
        orderController = new OrderController(orderService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getRequestURI();

        if (Pattern.matches(API_PATH_WITH_NUMBERS, path)) {

            long id = extractId(path);
            orderController.findOrderById(id, resp);
            return;
        }

        orderController.findAllOrders(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            orderController.saveOrder(req.getReader(), resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getRequestURI();

        if (Pattern.matches(API_PATH_WITH_NUMBERS, path)) {
            long id = extractId(path);
            orderController.deleteOrderById(id, resp);
        }
    }

    private long extractId(String path) {
        String NUMBER_PATTERN = "[^0-9]";
        return Long.parseLong(path.replaceAll(NUMBER_PATTERN, ""));
    }
}
