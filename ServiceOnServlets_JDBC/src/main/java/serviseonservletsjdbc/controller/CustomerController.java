package serviseonservletsjdbc.controller;

import com.google.gson.Gson;
import serviseonservletsjdbc.dto.CustomerResponse;
import serviseonservletsjdbc.entity.Customer;
import serviseonservletsjdbc.service.CustomerService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

public class CustomerController {

    public static final String APPLICATION_JSON = "application/json";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void saveUser(Reader body, HttpServletResponse response) throws SQLException, IOException {

        response.setContentType(APPLICATION_JSON);
        final Gson gson = new Gson();
        final Customer customer = gson.fromJson(body, Customer.class);
        customerService.saveUser(customer);
        response.getWriter().print(gson.toJson("User creation is successful"));
    }

    public void deleteById(Long id, HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        final CustomerResponse customer = customerService.findUserById(id);
        customerService.deleteUserById(id);
        final Gson gson = new Gson();
        response.getWriter().print(gson.toJson(customer));
    }

    public void findCustomerById(long id, HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        final CustomerResponse customer = customerService.findUserById(id);
        final Gson gson = new Gson();
        response.getWriter().print(gson.toJson(customer));
    }

    public void findAllCustomers(HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        List<CustomerResponse> customers = customerService.findAllUsers();
        final Gson gson = new Gson();
        response.getWriter().print(gson.toJson(customers));
    }

}
