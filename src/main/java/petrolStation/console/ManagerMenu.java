package petrolStation.console;

import petrolStation.services.ManagerService;

public class ManagerMenu {

    public static void managerMenu() {
        System.out.println
                ("1: Новая заправка\n2: Отмена заказа\n3: Изменить стоимость топлива\n0: Выход");
        final int answer = Reader.readInt();
        while (true) {
            switch (answer) {
                case 1:
                    ManagerService.newOrder();
                    managerMenu();
                case 2:
                    ManagerService.deleteOrder();
                    managerMenu();
                case 3:
                    ManagerService.updatePetrolPrice();
                    managerMenu();
                case 0:
                    MainMenu.mainMenu();
            }
        }
    }
}
