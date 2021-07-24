package petrolStation.console;

import petrolStation.model.Station;
import petrolStation.services.AdminService;

public class AdminMenu {

    public static void adminMenu() {
        System.out.println
                ("1:Создать станцию\n2:Список станций\n3:Выбрать станцию\n4:Удалить станцию\n0: Главное меню");
        int answer = Reader.readInt();
        while (true) {
            switch (answer) {
                case 1:
                    AdminService.createStation();
                    adminMenu();
                case 2:
                    System.out.println(AdminService.showListStations(AdminService.getAllStations()));
                    adminMenu();
                case 3:
                    final Station station = AdminService.selectStation();
                    selectStation(station);
                    adminMenu();
                case 4:
                    AdminService.deleteStation();
                    adminMenu();
                case 0:
                    MainMenu.start();
            }
        }
    }

    public static void selectStation(Station station) {
        System.out.println
                ("1:Список топлива доступного на станции\n2:Добавить топливо\n3:Удалить топливо\n0: Назад");
        int answer = Reader.readInt();
        while (true) {
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
                case 0:
                    adminMenu();
            }
        }
    }
}
