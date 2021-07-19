package petrolStation.services;

import petrolStation.Console.AdminMassages;
import petrolStation.Console.Reader;
import petrolStation.DAO.AdminDAO;
import petrolStation.DAO.ManagerDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.util.List;

public class AdminService {

    public static void createStation() {
        final String name = Reader.readString(AdminMassages.inputName);
        AdminDAO.createStation(new Station(name));
    }

    public static List<Station> getAllStations() {
        return AdminDAO.getAllStation();
    }

    public static Station getStationById() {
        final int idStation = Reader.readInt(AdminMassages.inputIdStation);
        return AdminDAO.getStationById(idStation);
    }

    public static void deleteStation() {
        final List<Station> allStation = AdminDAO.getAllStation();
        System.out.println(showList(allStation));
        final int id = Reader.readInt("Введите id колонки(станции) для удаления");
        final Station station = AdminDAO.getStationById(id);
        AdminDAO.deleteStation(station);
    }

    public static List<Petrol> getAllPetrol() {
        return AdminDAO.getAllPetrol();
    }

    public static Petrol getPetrolById(int id) {
        return AdminDAO.getPetrolById(id);
    }


    public static void join(Station s) {
        System.out.println(showList(AdminDAO.getAllPetrol()));
        final int id = Reader.readInt("Введите id топлива для добавления");
        final Petrol petrolById = AdminDAO.getPetrolById(id);
        AdminDAO.join(s,petrolById);
    }

    public static void showJoin(Station s) {
        System.out.println(showList(AdminDAO.showJoin(s)));
    }



    public static void deletePetrol(Station s){
        System.out.println(showList(AdminDAO.showJoin(s)));
        final int id = Reader.readInt("Введите id топлива для его удаления");
        AdminDAO.deletePetrol(s,id);
    }



    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }



}

