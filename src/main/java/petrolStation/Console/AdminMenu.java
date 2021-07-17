package petrolStation.Console;

import petrolStation.DAO.AdminDAO;
import petrolStation.model.Station;
import petrolStation.services.AdminService;

import java.util.List;

public class AdminMenu {


    public static void AdminMenu() {
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
                    selectStation();
                case 4:



            }


        }
    }

    public static void selectStation(Station station){
        int answer = Reader.readInt();
        /**Место для меню выбора станции*/
        while (answer != 0){
            switch (answer){
                /**Удалить станцию*/
                case 1:
                    final boolean b = AdminService.deleteStation(station);
                    if (b) {
                        System.out.println(AdminMassages.successfully);
                    }else{
                        System.out.println(AdminMassages.error);
                    }
                case 2:
                    
                    AdminService.join(station);



            }
        }


    }
}
