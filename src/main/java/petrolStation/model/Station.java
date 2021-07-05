package petrolStation.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "station_table")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    private List<Petrol> petrolList = new ArrayList<>();

    public void add(Petrol petrol) {
        petrolList.add(petrol);
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

    public void deleteById(int id){
        petrolList.removeIf(tmp -> tmp.getId() == id);
    }
}
