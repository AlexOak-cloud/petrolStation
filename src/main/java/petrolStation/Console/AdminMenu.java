package petrolStation.Console;

import petrolStation.DAO.AdminDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;
import petrolStation.services.AdminService;

import java.util.List;

public class AdminMenu {

    public static void adminMenu() {
        System.out.println(AdminMassages.mainMenu);
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
        System.out.println(AdminMassages.selectMenu);
        int answer = Reader.readInt();
        while (answer != 0) {
            switch (answer) {
                case 1:
                    AdminService.showJoin(station);
                    selectStation(station);
                case 2:
                    AdminService.join(station);
                    selectStation(station);
                case 3:
                    AdminService.deletePetrol(station);
                    selectStation(station);
                case 4:
                    AdminService.deleteStation();
                    selectStation(station);
                case 0:
                    adminMenu();
            }
        }
    }
}
