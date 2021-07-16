package petrolStation.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "tbl_petrol")
@Data
public class Petrol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_petrol")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;

    public int getId() {
        return id;
    }

    public Petrol() {

    }

    @Override
    public String toString() {
        return "Petrol{name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Petrol(String name, int price) {
        this.name = name;
        this.price = price;
    }


}
