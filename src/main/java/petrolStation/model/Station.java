package petrolStation.model;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@Data
@Entity
@Table(name = "station_table")
@Builder
public class Station<Petrol> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    private Petrol[] petrol;

    


}
