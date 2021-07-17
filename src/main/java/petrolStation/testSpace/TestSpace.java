package petrolStation.testSpace;

import petrolStation.DAO.AdminDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.util.ArrayList;
import java.util.List;

public class TestSpace {
    public static void main(String[] args) {
        Petrol petrol = new Petrol("92", 23);
        Petrol petrol1 = new Petrol("95", 25);
        Petrol petrol2 = new Petrol("98", 27);
        Station s = new Station("1");


//        final List<Station> allStation = AdminDAO.getAllStation();
//        System.out.println(showList(allStation));
//        final List<Petrol> allPetrol = AdminDAO.getAllPetrol();
//        System.out.println(showList(allPetrol));

        final Station stationById = AdminDAO.getStationById(17);
        final Petrol petrolById = AdminDAO.getPetrolById(18);
        final Petrol petrolById1 = AdminDAO.getPetrolById(19);

//        System.out.println(AdminDAO.joining(stationById, petrolById, petrolById1));
        System.out.println(AdminDAO.showJoinByStations(stationById));


//        final Station stationById = AdminDAO.getStationById(15);
//        final Petrol petrolById = AdminDAO.getPetrolById(12);
//        final Petrol petrolById1 = AdminDAO.getPetrolById(14);
//
//        AdminDAO.joining(stationById,petrolById,petrolById1);
//
//        System.out.println(AdminDAO.showJoinByStations(stationById));


//        AdminDAO.joining()


    }

    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}
