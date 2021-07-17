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
                ", name='" + name +"}";

    }
}
