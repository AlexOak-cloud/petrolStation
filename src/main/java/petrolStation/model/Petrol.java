package petrolStation.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_petrol")
@Data
@RequiredArgsConstructor
public class Petrol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_petrol")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;

    /**
     *  Create table tbl_petrol (
     *  id_petrol int primary key auto_increment,
     *  name varchar(255) not null,
     *  price int not null check (price >0));
     */
}
