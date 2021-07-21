package petrolStation.services;

import petrolStation.console.Reader;
import petrolStation.DAO.AdminDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.util.List;

public class AdminService {


    public static void createStation() {
        final String name = Reader.readString("Введите имя/номер новой станции");
        AdminDAO.createStation(new Station(name));
    }


    public static List<Station> getAllStations() {
      return AdminDAO.getAllStation();

    }

    public static void showAllStation() {
        final List<Station> allStations = AdminDAO.getAllStation();
        int number = 1;
        for (Station tmp : allStations) {
            System.out.println(number + ": " + tmp);
            number++;
        }
    }

    public static Station getStationById() {
        showAllStation();
        final List<Station> allStations = getAllStations();
        final int idStation = Reader.readInt("Выберите номер станции", 1, allStations.size() + 1);
        return allStations.get(idStation - 1);
    }


    public static void deleteStation() {
        final List<Station> allStation = AdminDAO.getAllStation();
        System.out.println(showListStations(allStation));
        final int id = Reader.readInt("Введите номер колонки(станции) для удаления",
                1, allStation.size() + 1);
        final Station station = AdminDAO.getStationById(id);
        AdminDAO.deleteStation(station);
    }


    public static void join(Station s) {
        System.out.println(showListPetrol(AdminDAO.getAllPetrol()));
        final int idPetrol = Reader.readInt
                ("Введите id топлива для добавления", 18, 21);
        final Petrol petrol = AdminDAO.getPetrolById(idPetrol);
        AdminDAO.join(s, petrol);
    }



    public static List<Petrol> showJoin(Station s) {
        final List<Petrol> petrol = AdminDAO.showJoin(s);
        if(petrol.get(0).equals(null)){
            System.out.println("Нет доступного топлива на станции\n");
        } else {
            System.out.println(showListPetrol(petrol));
        }
        return AdminDAO.showJoin(s);
    }


    public static void deletePetrol(Station s) {
        System.out.println(showListPetrol(AdminDAO.showJoin(s)));
        final int id = Reader.readInt
                ("Введите id топлива для его удаления", 18, 21);
        AdminDAO.deletePetrol(s, id);
    }


    public static String showListStations(List<Station> list) {
        StringBuilder sb = new StringBuilder();
        int number = 1;
        for (Station tmp : list) {
            sb.append(number).append(": Station = ").append(tmp.getName()).append("\n");
            number++;
        }
        return sb.toString();
    }

    public static String showListPetrol(List<Petrol> list){
        StringBuilder sb = new StringBuilder();
        int number = 1;
        for (Petrol tmp : list) {
            sb.append(number).append(": Petrol = ").append(tmp.getName()).append(", price= ").append(tmp.getPrice());
            number++;
        }
        return sb.toString();
    }


}

