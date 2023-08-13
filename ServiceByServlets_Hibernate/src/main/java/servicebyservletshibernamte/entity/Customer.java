package servicebyservletshibernamte.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

}
