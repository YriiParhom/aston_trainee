package serviseonservletsjdbc.dto;

public class CustomerResponse {

    private Long id;
    private String name;
    private String surname;


    public CustomerResponse() {
    }

    public CustomerResponse(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
