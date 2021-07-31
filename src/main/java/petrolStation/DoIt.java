package petrolStation;

import petrolStation.model.Petrol;
import petrolStation.model.Station;
import petrolStation.util.serialization.JoinSer;

import java.util.ArrayList;
import java.util.List;

public class DoIt {

    public static void main(String[] args) {
        Station station = new Station("aasd");
        Station station1 = new Station("qwe");
        Petrol petrol = new Petrol("92",123);
        Petrol petro1l = new Petrol("95",134);
        Petrol petro2l = new Petrol("98",145);
        List<Petrol> listPetrol = new ArrayList<>();
        List<Petrol> list2 = new ArrayList<>();
        list2.add(petrol);
        list2.add(petrol);
        list2.add(petrol);
        listPetrol.add(petro1l);
        listPetrol.add(petrol);
        listPetrol.add(petro2l);
        Join join = new Join(station,listPetrol);
        Join join1 = new Join(station,list2);
        JoinSer.write(join);
        final List<Join> joins = JoinSer.readList();

        System.out.println("Первый лист \n" + showlIst(joins));

        JoinSer.write(join1);
        final List<Join> joins1 = JoinSer.readList();

        System.out.println("Второй лист \n" + showlIst(joins1));

        JoinSer.delete(join);
        final List<Join> joins2 = JoinSer.readList();

        System.out.println("Удаление \n" + showlIst(joins2));







    }

    public static <T> String showlIst(List<T> list){
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list ){
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}
