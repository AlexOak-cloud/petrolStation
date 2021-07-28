package petrolStation;

import petrolStation.console.MainMenu;
import petrolStation.model.Join;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.util.ArrayList;
import java.util.List;

public class DoIt {

    public static void main(String[] args) {
        Station station = new Station("aasd");
        Petrol petrol = new Petrol("92",123);
        Petrol petro1l = new Petrol("95",134);
        Petrol petro2l = new Petrol("98",145);
        List<Petrol> listPetrol = new ArrayList<>();
        listPetrol.add(petro1l);
        listPetrol.add(petrol);
        listPetrol.add(petro2l);
        Join join = new Join(station,listPetrol);
        System.out.println(join);




    }
}
