package petrolStation.services;

import petrolStation.Console.AdminMassages;
import petrolStation.Console.Reader;
import petrolStation.DAO.AdminDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class AdminService {

    public static boolean createStation(String name) {
        Station station = new Station(name);
        return AdminDAO.createStation(station);
    }

    public static List<Station> getAllStations() {
        return AdminDAO.getAllStation();
    }

    public static Station getStationById(int id) {
        return AdminDAO.getStationById(id);
    }

    public static void deleteStation() {
        final List<Station> allStation = AdminDAO.getAllStation();
        System.out.println(showList(allStation));
        final int id = Reader.readInt("Введите id колонки для удаления");
        final Station station = AdminDAO.getStationById(id);
        final boolean b = AdminDAO.deleteStation(station);
        if (b) {
            System.out.println(AdminMassages.successfully);
        } else {
            System.out.println(AdminMassages.error);
        }
    }

    public static List<Petrol> getAllPetrol() {
        return AdminDAO.getAllPetrol();
    }

    public static Petrol getPetrolById(int id) {
        return AdminDAO.getPetrolById(id);
    }

    public static boolean join(Station s, Petrol... p) {
        return AdminDAO.join(s, p);
    }

    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}

