package petrolStation.model;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;


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
    private petrolStation.model.Petrol[] petrolList;
    private int sizeList;


    public Station(int size) {
        this.petrolList = (petrolStation.model.Petrol[]) new Object[size];
        this.sizeList = 0;
    }

    public int size() {
        return sizeList;
    }

    private void expansion() {
        if (sizeList + 1 > petrolList.length) {
            petrolStation.model.Petrol[] tmp =
                    (petrolStation.model.Petrol[]) new Object[petrolList.length * 2];

            for (int i = 0; i < petrolList.length; i++) {
                tmp[i] = petrolList[i];
            }
            petrolList = tmp;
        }
    }

    public void add(petrolStation.model.Petrol petrol) {
        expansion();
        petrolList[sizeList + 1] = petrol;
    }


    public String getAll(){
        String rtn = "";
        for(petrolStation.model.Petrol tmp : petrolList){
            rtn += tmp + "\n";
        }
        return rtn;
    }

    public petrolStation.model.Petrol getById(int id){
        petrolStation.model.Petrol p = new petrolStation.model.Petrol();
        for(petrolStation.model.Petrol tmp : petrolList){
            if(tmp.getId() == id){
                p=tmp;
            }
        }
        return p;
    }

    public boolean deleteById(int id){
        for(petrolStation.model.Petrol tmp : petrolList){
            if(tmp.getId() == id){



            }

        }



    }


}
