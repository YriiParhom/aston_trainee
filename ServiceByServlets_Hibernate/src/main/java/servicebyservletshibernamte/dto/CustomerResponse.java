package servicebyservletshibernamte.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import servicebyservletshibernamte.entity.Order;

import java.util.Set;


@AllArgsConstructor
@Setter
@Getter
public class CustomerResponse {

    private Long id;

    private String name;

    private String surname;

    private Set<Order> orders;
}
