package petrolStation.services;

import petrolStation.DAO.JoinDAO;
import petrolStation.DAO.PetrolDAO;
import petrolStation.console.AdminMenu;
import petrolStation.console.Reader;
import petrolStation.DAO.StationDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;
import petrolStation.serialization.Repository;
import petrolStation.serialization.Serialazer;

import java.util.Iterator;
import java.util.List;

public class AdminService {

    public static void create() {
        final String name = Reader.readString("Введите имя/номер новой станции\n0: Назад");
        if (name.equals("0")) {
            AdminMenu.adminMenu();
        }
        Station station = new Station(name);
        StationDAO.action().create(station);
        Serialazer.action().write(station, Repository.getFileStation());
    }


    public static List<Station> getAll() {
        return StationDAO.action().getAll();
    }


    public static Station selectStation() {
        final List<Station> allStations = getAll();
        System.out.println(showListStations(allStations));
        final int number = Reader.readInt
                ("Выберите номер станции\n0: Назад", 0, allStations.size() + 1);
        if (number == 0) {
            AdminMenu.adminMenu();
        }
        return allStations.get(number - 1);
    }


    public static void deleteStation() {
        final List<Station> allStation = getAll();
        System.out.println(showListStations(allStation));
        final int number = Reader.readInt("Введите номер колонки(станции) для удаления",
                0, allStation.size() + 1);
        if (number == 0) {
            AdminMenu.adminMenu();
        }
        Station station = allStation.get(number-1);
        StationDAO.action().delete(station);
        Serialazer.action().delete(station,Repository.getFileStation());
    }


    public static void join(Station s) {
        System.out.println(showListPetrol(PetrolDAO.action().getAll()));
        final int idPetrol = Reader.readInt
                ("Введите номер топлива для добавления\n0: Назад", 0, 4);
        if (idPetrol == 0) {
            AdminMenu.selectStation(s);
        }
        JoinDAO.join(s, PetrolDAO.action().getById(idPetrol));
    }


    public static List<Petrol> showJoin(Station s) {
        System.out.println(s + ": ");
        final List<Petrol> petrol = JoinDAO.showJoin(s);
        Iterator<Petrol> iterator = petrol.listIterator();
        if (!iterator.hasNext()) {
            System.out.println("Нет доступного топлива на станции\n");
            AdminMenu.selectStation(s);
        } else {
            System.out.println(showListPetrol(petrol));
        }
        return JoinDAO.showJoin(s);
    }


    public static void deletePetrol(Station s) {
        final List<Petrol> petrol = JoinDAO.showJoin(s);
        System.out.println(showListPetrol(petrol));
        final int id = Reader.readInt
                ("Введите номер топлива для его удаления\n0: Назда", 0, petrol.size() + 1);
        if (id == 0) {
            AdminMenu.selectStation(s);
        }
        JoinDAO.deletePetrol(s, id);
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

