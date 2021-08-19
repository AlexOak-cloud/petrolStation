package petrolStation.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "stations")
public class Station implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;


    public Station() {
    }

    public Station(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getName(){
        return name;
    }


    @Override
    public String toString() {
        return "Station (" + name + ")";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return id == station.id && Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    /**Таблица для хранения информации о заправочных станциях (колонках) ->
     *       CREATE TABLES stations ( id INT PRIMARY KEY AUTO_INCREMENT,
     *                               name VARCHAR(255)NOT NULL )
     *                               ENGINE=INNODB;
     *
     *
     *Таблица для хранения информации о связи станций с видами топлива ->
     *       CREATE TABLE petrol_station(id_station INT,
     *                                    id_petrol INT,
     *                                    PRIMARY KEY(id_station, id_petrol),
     *                                    FOREIGN KEY(id_station) REFERENCES stations(id) ON DELETE CASCADE ON UPDATE CASCADE,
     *                                    FOREIGN KEY(id_petrol) REFERENCES petrol(id) ON DELETE CASCADE ON UPDATE CASCADE)
     *                                    ENGINE = INNODB ;
     * */
}
