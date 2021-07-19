package petrolStation;

import petrolStation.DAO.AdminDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.util.List;

public class DoIt {
    public static void main(String[] args) {
        Station station = new Station("1");
        Station station1 = new Station("2");
        Petrol petrol = new Petrol("92",123);
        Petrol petrol1 = new Petrol("95",321);
//        AdminDAO.createStation(station1);
//        AdminDAO.createPetrol(petrol);
//        Petrol petrolById = AdminDAO.getPetrolById(5);
//        Station stationById = AdminDAO.getStationById(3);
//        System.out.println(petrolById);
//        System.out.println(stationById);
//          AdminDAO.deletePetrol(petrolById);
//          AdminDAO.deleteStation(stationById);
//        List<Petrol> allPetrol = AdminDAO.getAllPetrol();
//       List<Station> allStation = AdminDAO.getAllStation();
//        System.out.println(showList(allStation));
//        System.out.println(showList(allPetrol));
//        Petrol p = AdminDAO.getPetrolById(4);
//        Petrol p1 = AdminDAO.getPetrolById(7);
        Station s = AdminDAO.getStationById(2);
//        System.out.println(AdminDAO.joining(s, p, p1));

    }
    public static <T> String showList(List<T> list){
        StringBuilder builder = new StringBuilder();
        for(Object tmp: list){
            builder.append(tmp).append("\n");
        }
        return builder.toString();
    }
}
