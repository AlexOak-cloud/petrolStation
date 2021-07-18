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

    public Petrol(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
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

    /**
     *        CREATE TABLE petrol ( id INT PRIMARY KEY AUTO_INCREMENT,
     *                             name VARCHAR(255) NOT NULL,
     *                             price INT NOT NULL CHECK (price > 0 ))
     *                             ENGINE = INNODB;
     *
     *
     *        CREATE TABLE petrol_station(id_station INT,
     *                                    id_petrol INT,
     *                                    PRIMARY KEY(id_station, id_petrol),
     *                                    FOREIGN KEY(id_station) REFERENCES stations(id) ON DELETE CASCADE ON UPDATE CASCADE,
     *                                    FOREIGN KEY(id_petrol) REFERENCES petrol(id) ON DELETE CASCADE ON UPDATE CASCADE)
     *                                    ENGINE = INNODB ;
     *
     *
     * */


}
