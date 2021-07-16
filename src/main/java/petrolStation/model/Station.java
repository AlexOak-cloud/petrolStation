package petrolStation.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;

@Entity
@Table(name = "tbl_stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_station")
    private int id;
    @Column(name = "name")
    private String name;
    private ArrayList<Petrol> petrolList = new ArrayList<>();


    public Station(String name, Petrol... petrol) {
        this.name = name;
        Collections.addAll(petrolList, petrol);
    }

    public Station() {
    }


    public int getId() {
        return id;
    }


    /**
     * Метод showList() возвращает содержимое ArrayList<Petrol>petrolList.
     * Используется для улучшения метода toString()
     */

    public String showList() {
        StringBuilder sb = new StringBuilder();
        for (Petrol tmp : petrolList) {
            sb.append(tmp).append(", ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", name='" + name + "' [" +
                showList() + "]" +
                '}';
    }
}
