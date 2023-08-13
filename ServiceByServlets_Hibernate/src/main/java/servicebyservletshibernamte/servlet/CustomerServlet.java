package servicebyservletshibernamte.servlet;

import servicebyservletshibernamte.controller.CustomerController;
import servicebyservletshibernamte.repository.CustomerRepository;
import servicebyservletshibernamte.repository.CustomerRepositoryImpl;
import servicebyservletshibernamte.service.CustomerService;
import servicebyservletshibernamte.service.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class CustomerServlet extends HttpServlet {

    private final static String API_PATH = "/api/customers";
    private final static String API_PATH_WITH_NUMBERS = API_PATH + "/\\d+";
    private CustomerController customerController;

    @Override
    public void init() throws ServletException {
        final CustomerRepository customerRepository = new CustomerRepositoryImpl();
        final CustomerService customerService = new CustomerServiceImpl(customerRepository);
        customerController = new CustomerController(customerService);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getRequestURI();

        if (Pattern.matches(API_PATH_WITH_NUMBERS, path)) {
            final long id = extractId(path);
            customerController.findCustomerById(id, resp);
            return;
        }

        customerController.findAllCustomers(resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        customerController.addCustomer(req.getReader(), resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();
        if (Pattern.matches(API_PATH_WITH_NUMBERS, path)) {
            long id = extractId(path);
            customerController.deleteCustomer(id, resp);
        }
    }

    private long extractId(String path) {
        String NUMBER_PATTERN = "[^0-9]";
        return Long.parseLong(path.replaceAll(NUMBER_PATTERN, ""));
    }
}
