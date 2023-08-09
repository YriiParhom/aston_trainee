package serviseonservletsjdbc.entity;

public class Order {

    private long id;

    private String name;

    private Double price;

    private Long owner;


    public Order() {
    }

    public Order(long id, String name, Double price, Long owner) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.owner = owner;
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

    public void setOwner(Long owner) {
        this.owner = owner;
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

    public Long getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", customerId=" + owner +
                '}';
    }
}
