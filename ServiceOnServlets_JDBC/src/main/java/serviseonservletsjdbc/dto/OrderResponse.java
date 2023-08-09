package serviseonservletsjdbc.dto;

import java.util.Date;

public class OrderResponse {

    private Long id;

    private String name;

    private Double price;

    private String customerName;

    private String customerSurname;

    public OrderResponse() {
    }

    public OrderResponse(
            Long id,
            String name,
            Double price,
            String customerName,
            String customerSurname) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }
}
