package petrolStation.services;

import javafx.animation.ParallelTransition;
import petrolStation.DAO.AdminDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.util.List;

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

    public static boolean deleteStation(Station station) {
        return AdminDAO.deleteStation(station);
    }

    public static boolean createPetrol(Petrol petrol) {
        return AdminDAO.createPetrol(petrol);
    }

    public static List<Petrol> getAllPetrol() {
        return AdminDAO.getAllPetrol();
    }

    public static Petrol getPetrolById(int id) {
        return AdminDAO.getPetrolById(id);
    }

    public static boolean deletePetrol(Petrol petrol) {
        return AdminDAO.deletePetrol(petrol);
    }

    public static boolean join(Station s, Petrol... p) {
        return AdminDAO.join(s, p);
    }
}

