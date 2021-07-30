package petrolStation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "petrol")
public class Petrol implements Serializable {
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

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }


    public Petrol() {
    }

    public Petrol(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Petrol(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Топливо ("+ name +", " +
                ", цена=" + price +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Petrol petrol = (Petrol) o;
        return id == petrol.id && price == petrol.price && Objects.equals(name, petrol.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
    /**Таблица для хранения информации о видах топлива и ценах ->
     *        CREATE TABLE petrol ( id INT PRIMARY KEY AUTO_INCREMENT,
     *                             name VARCHAR(255) NOT NULL,
     *                             price INT NOT NULL CHECK (price > 0 ))
     *                             ENGINE = INNODB;
     *
     *Таблица для хранения информации о связи станций с видами топлива ->
     *        CREATE TABLE petrol_station(id_station INT,
     *                                    id_petrol INT,
     *                                    PRIMARY KEY(id_station, id_petrol),
     *                                    FOREIGN KEY(id_station) REFERENCES stations(id) ON DELETE CASCADE ON UPDATE CASCADE,
     *                                    FOREIGN KEY(id_petrol) REFERENCES petrol(id) ON DELETE CASCADE ON UPDATE CASCADE)
     *                                    ENGINE = INNODB ;
     */


}
