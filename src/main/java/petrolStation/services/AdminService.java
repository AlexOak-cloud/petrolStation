package petrolStation.services;

import petrolStation.console.AdminMenu;
import petrolStation.console.Reader;
import petrolStation.DAO.AdminDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.util.Iterator;
import java.util.List;

public class AdminService {


    public static void createStation() {
        final String name = Reader.readString("Введите имя/номер новой станции\n0: Назад");
        if (name.equals("0")) {
            AdminMenu.adminMenu();
        }
        AdminDAO.createStation(new Station(name));
    }


    public static List<Station> getAllStations() {
        return AdminDAO.getAllStation();

    }


    public static Station selectStation() {
        final List<Station> allStations = getAllStations();
        System.out.println(showListStations(allStations));
        final int idStation = Reader.readInt
                ("Выберите номер станции\n0: Назад", 0, allStations.size() + 1);
        if (idStation == 0) {
            AdminMenu.adminMenu();
        }
        return allStations.get(idStation - 1);
    }


    public static void deleteStation() {
        final List<Station> allStation = AdminDAO.getAllStation();
        System.out.println(showListStations(allStation));
        final int number = Reader.readInt("Введите номер колонки(станции) для удаления",
                0, allStation.size() + 1);
        if (number == 0) {
            AdminMenu.adminMenu();
        }
        AdminDAO.deleteStation(allStation.get(number - 1));
    }


    public static void join(Station s) {
        System.out.println(showListPetrol(AdminDAO.getAllPetrol()));
        final int idPetrol = Reader.readInt
                ("Введите номер топлива для добавления\n0: Назад", 0, 4);
        if (idPetrol == 0) {
            AdminMenu.selectStation(s);
        }
        AdminDAO.join(s, AdminDAO.getPetrolById(idPetrol));
    }


    public static List<Petrol> showJoin(Station s) {
        System.out.println(s + ": ");
        final List<Petrol> petrol = AdminDAO.showJoin(s);
        Iterator<Petrol> iterator = petrol.listIterator();
        if (!iterator.hasNext()) {
            System.out.println("Нет доступного топлива на станции\n");
            AdminMenu.selectStation(s);
        } else {
            System.out.println(showListPetrol(petrol));
        }
        return AdminDAO.showJoin(s);
    }


    public static void deletePetrol(Station s) {
        final List<Petrol> petrol = AdminDAO.showJoin(s);
        System.out.println(showListPetrol(petrol));
        final int id = Reader.readInt
                ("Введите номер топлива для его удаления\n0: Назда", 0, petrol.size() + 1);
        if (id == 0) {
            AdminMenu.selectStation(s);
        }
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

    public static String showListPetrol(List<Petrol> list) {
        StringBuilder sb = new StringBuilder();
        int number = 1;
        for (Petrol tmp : list) {
            sb.append(number).append(": Petrol = ").append(tmp.getName()).
                    append(", price= ").append(tmp.getPrice()).append("\n");
            number++;
        }
        return sb.toString();
    }
}

