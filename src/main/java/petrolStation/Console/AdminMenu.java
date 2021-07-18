package petrolStation.Console;

import petrolStation.DAO.AdminDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;
import petrolStation.services.AdminService;

import java.util.List;

public class AdminMenu {

    public static void adminMenu() {
        System.out.println(AdminMassages.mainMenu);
        /*1:Создать станцию
         2:Список станций
         3:Выбрать станцию по ID
         4:Удалить станцию
         0: Выход*/
        int answer = Reader.readInt();
        while (answer != 0) {
            switch (answer) {
                case 1:
                    AdminService.createStation();
                    adminMenu();
                case 2:
                    System.out.println(AdminService.showList(AdminService.getAllStations()));
                    adminMenu();
                case 3:
                    final Station station = AdminService.getStationById();
                    selectStation(station);//Закончить
                    adminMenu();
                case 4:
                    AdminService.deleteStation();
                    adminMenu();
                case 0:
                    MainMenu.mainMenu();
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
            selectStation(station);               //?????????? 
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
