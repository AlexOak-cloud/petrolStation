package petrolStation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_stations")
public class Station {
    /**
     * Таблица для хранения информации о станциях ->
     * Create table tbl_stations (
     * id_station int auto_increment primary key,
     * name varchar(255),
     * <p>
     * <p>
     * <p>
     * Таблица для хранения информации о связи топлива и станции ->
     * Create table petrol_and_stations(
     * id_station int,
     * id_petrol int,
     * primary key(id_petrol, id_station),
     * foreign key(id_station) references tbl_stations(id_station) on delete cascade,
     * foreign key(id_petrol) references tbl_petrol(id_petrol) on delete cascade);
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_station")
    private int id;
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public Station(String name) {
        this.name = name;
    }

    public Station() {
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
