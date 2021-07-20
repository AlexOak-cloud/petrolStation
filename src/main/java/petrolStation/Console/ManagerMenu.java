package petrolStation.Console;

import petrolStation.services.ManagerService;

public class ManagerMenu {

    public static void managerMenu() {
        System.out.println(ManagerMassages.managerMenu);
        final int answer = Reader.readInt();
        while (answer != 0) {
            switch (answer) {
                case 1:
                    ManagerService.newOrder();
                    managerMenu();
                case 2:
                    ManagerService.cancallations();
                    managerMenu();
                case 3:
                    ManagerService.updatePetrolPrice();
                    managerMenu();
                case 4:
                    MainMenu.mainMenu();
            }
        }
    }
}
