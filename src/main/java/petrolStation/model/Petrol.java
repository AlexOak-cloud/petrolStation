package petrolStation.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_petrol")
@Data
@RequiredArgsConstructor
public class Petrol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_petrol")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;

    /**
     * Таблица для хранения информации о топливе ->
     *         Create table tbl_petrol (
     *             id_petrol int primary key auto_increment,
     *             name varchar(255) not null,
     *             price int not null check (price >0));
     *
     *
     * Таблица для хранения информации о связи топлива и станции ->
     *         Create table petrol_and_stations(
     *             id_station int,
     *             id_petrol int,
     *             primary key(id_petrol, id_station),
     *             foreign key(id_station) references tbl_stations(id_station),
     *             foreign key(id_petrol) references tbl_petrol(id_petrol));
     */
}
