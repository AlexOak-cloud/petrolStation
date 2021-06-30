package petrolStation.model;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "station_table")
@Builder
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "petrol1")
    private Petrol petrol1;
    @Column(name = "petrol2")
    private Petrol petrol2;
    @Column(name = "petrol3")
    private Petrol petrol3;
    @Column(name = "petrol4")
    private Petrol petrol4;
}
