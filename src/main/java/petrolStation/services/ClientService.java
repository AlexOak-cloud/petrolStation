package petrolStation.services;

import petrolStation.console.Reader;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.util.List;

public class ClientService {


    public static Petrol selectPetrol(){
        final Station stationById = AdminService.getStationById();
        System.out.println("Топливо доступное на станции : \n");
        final List<Petrol> petrol = AdminService.showJoin(stationById);
        System.out.println(showPetrolList(AdminService.showJoin(stationById)));
        final int rtnPetrol = Reader.readInt("Для выбора введите число", 1, petrol.size() + 1);
        return petrol.get(rtnPetrol + 1);
    }

    public static String showPetrolList(List<Petrol> list){
        StringBuilder sb = new StringBuilder();
        int number = 1;
        for(Petrol tmp : list){
            sb.append(number).append(": ").append(tmp.getName()).
                    append(", price=").append(tmp.getPrice()).append("\n");
            number++;
        }
        return sb.toString();
    }

    public static void newOrder(){
        final Petrol petrol = selectPetrol();

    }
}
