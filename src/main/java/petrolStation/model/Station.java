package petrolStation.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;

@Entity
@Table(name = "stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;


    public Station(String name) {
        this.name = name;
    }

    public Station() {
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + "}";

    }


    /**
     *       CREATE TABLES stations ( id INT PRIMARY KEY AUTO_INCREMENT,
     *                               name VARCHAR(255)NOT NULL )
     *                               ENGINE=INNODB;
     *
     *
     *
     *       CREATE TABLE petrol_station(id_station INT,
     *                                    id_petrol INT,
     *                                    PRIMARY KEY(id_station, id_petrol),
     *                                    FOREIGN KEY(id_station) REFERENCES stations(id) ON DELETE CASCADE ON UPDATE CASCADE,
     *                                    FOREIGN KEY(id_petrol) REFERENCES petrol(id) ON DELETE CASCADE ON UPDATE CASCADE)
     *                                    ENGINE = INNODB ;
     * */
}
