package serviseonservletsjdbc.servlet;

import serviseonservletsjdbc.controller.CustomerController;
import serviseonservletsjdbc.repository.CustomerRepository;
import serviseonservletsjdbc.repository.CustomerRepositoryImpl;
import serviseonservletsjdbc.service.CustomerService;
import serviseonservletsjdbc.service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class CustomerServlet extends HttpServlet {

    private CustomerController customerController;
    private final static String API_PATH = "/api/customers";
    private final static String API_PATH_WITH_NUMBERS = API_PATH + "/\\d+";


    @Override
    public void init() throws ServletException {
        final CustomerRepository customerRepository = new CustomerRepositoryImpl();
        final CustomerService customerService = new CustomerServiceImpl(customerRepository);
        customerController = new CustomerController(customerService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String path = req.getRequestURI();

        if(Pattern.matches(API_PATH_WITH_NUMBERS, path)) {
            final long id = extractId(path);
            customerController.findCustomerById(id, resp);
            return;
        }

        customerController.findAllCustomers(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            customerController.saveUser(req.getReader(), resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getRequestURI();
        if(Pattern.matches(API_PATH_WITH_NUMBERS, path)) {
            long id = extractId(path);
            customerController.deleteById(id, resp);
        }
    }

    private long extractId(String path) {
        String NUMBER_PATTERN = "[^0-9]";
        return Long.parseLong(path.replaceAll(NUMBER_PATTERN, ""));
    }
}
