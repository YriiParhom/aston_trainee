package serviseonservletsjdbc.entity;

import java.util.Date;

public class Order {

    private long id;

    private String name;

    private Double price;

    private Date date;

    private long customerId;


    public Order() {
    }

    public Order(long id, String name, Double price, Date date, long customerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.customerId = customerId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    public long getCustomerId() {
        return customerId;
    }
}
