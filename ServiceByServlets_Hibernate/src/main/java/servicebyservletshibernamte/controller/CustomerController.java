package servicebyservletshibernamte.controller;

import com.google.gson.Gson;
import servicebyservletshibernamte.dto.CustomerResponse;
import servicebyservletshibernamte.entity.Customer;
import servicebyservletshibernamte.service.CustomerService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class CustomerController {

    private static final String APPLICATION_JSON = "application/json";

    private final CustomerService customerService;

    private final Gson gson;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
        this.gson = new Gson();
    }

    public void addCustomer(Reader body, HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        Customer customer = gson.fromJson(body, Customer.class);
        customerService.addCustomer(customer);
        response.getWriter().print(gson.toJson("Customer created successful!"));
    }

    public void deleteCustomer(Long id, HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        Customer customer =  customerService.findCustomerById(id);
        customerService.deleteCustomer(customer);
        response.getWriter().print(gson.toJson("Delete is successful!"));

    }

    public void findCustomerById(Long id, HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        Customer customer = customerService.findCustomerById(id);
        response.getWriter().print(gson.toJson(customer));
    }

    public void findAllCustomers(HttpServletResponse response) throws IOException {

        response.setContentType(APPLICATION_JSON);
        List<Customer> customers = customerService.findAllCustomers();
        response.getWriter().print(gson.toJson(customers));
    }
}
