package petrolStation.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "tbl_stations")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_station")
    private int id;
    @Column(name = "name")
    private String name;


    /**
     *  create table tbl_stations (
     *         id_station int auto_increment primary key,
     *         name varchar(255),
     *         petrol_id int,
     *         foreign key(petrol_id) references tbl_petrol(id_petrol));
     */
}
