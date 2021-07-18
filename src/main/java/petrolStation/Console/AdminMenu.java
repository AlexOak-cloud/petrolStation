package petrolStation.Console;

import petrolStation.DAO.AdminDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;
import petrolStation.services.AdminService;

import java.util.List;

public class AdminMenu {


    public static void adminMenu() {
        int answer = Reader.readInt();
        while (answer != 0) {
            switch (answer) {
                case 1:
                    System.out.println(AdminMassages.createStation);
                    final String nameStation = Reader.readString(AdminMassages.inputName);
                    final boolean station = AdminService.createStation(nameStation);
                    if (station) {
                        System.out.println(AdminMassages.successfully);
                    } else {
                        System.out.println(AdminMassages.error);
                    }
                case 2:
                    System.out.println(AdminMassages.allStation + ": \n");
                    final List<Station> allStations = AdminService.getAllStations();
                    System.out.println(AdminService.showList(allStations));
                case 3:
//                    selectStation();
//                case 4:


            }


        }
    }

    public static void selectStation(Station station) {
        int answer = Reader.readInt();
        /**Место для меню выбора станции*/
        while (answer != 0) {
            switch (answer) {
                /**Удалить станцию*/
                case 1:
                    AdminService.deleteStation();
                case 2:
                    addPetrol(station);
                case 3:


            }
        }


    }


    public static void addPetrol(Station station) {
        final List<Petrol> allPetrol = AdminService.getAllPetrol();
        AdminService.showList(allPetrol);
        final int id = Reader.readInt("Введите id топлива");
        System.out.println(AdminMassages.back);
        if (id == 0) {
            selectStation(station);
        }
        final Petrol petrolById = AdminDAO.getPetrolById(id);
        final boolean join = AdminDAO.join(station, petrolById);
        if (join) {
            System.out.println(AdminMassages.successfully);
        } else {
            System.out.println(AdminMassages.error);
        }
        addPetrol(station);
    }

    public static void deletePetrol(Station station){
        final String s = AdminDAO.showJoinByStations(station);


    }



}
