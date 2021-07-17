package petrolStation.model;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "petrol")
@Data
public class Petrol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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

    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Petrol{id=" + id + ", name=" + name +
        ", price=" + price +
                '}';
    }

    public Petrol(String name, int price) {
        this.name = name;
        this.price = price;
    }


}
