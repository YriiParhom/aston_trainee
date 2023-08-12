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

    private final Gson gson;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
        this.gson = new Gson();
    }

    public void saveCustomer(Reader body, HttpServletResponse response) throws SQLException, IOException {

        response.setContentType(APPLICATION_JSON);
        Customer customer = gson.fromJson(body, Customer.class);
        customerService.saveCustomer(customer);
        response.getWriter().print(gson.toJson("User creation is successful"));
    }

    public void deleteById(Long id, HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        CustomerResponse customer = customerService.findCustomerById(id);
        customerService.deleteCustomerById(id);
        response.getWriter().print(gson.toJson(customer));
    }

    public void findCustomerById(long id, HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        CustomerResponse customer = customerService.findCustomerById(id);
        response.getWriter().print(gson.toJson(customer));
    }

    public void findAllCustomers(HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        List<CustomerResponse> customers = customerService.findAllCustomers();
        response.getWriter().print(gson.toJson(customers));
    }

}
