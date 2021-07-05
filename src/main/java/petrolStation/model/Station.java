package petrolStation.model;

import javax.persistence.*;

@Entity
@Table(name = "station_table")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

}
