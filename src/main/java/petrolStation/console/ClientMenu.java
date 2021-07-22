package petrolStation.console;

import petrolStation.services.ClientService;

public class ClientMenu {

    public static void clientMenu(){
        System.out.println("1: Оформить заказ\n2: Отменить заказ\n0: Выход");
        final int answer = Reader.readInt();
        while(true){
            switch (answer){
                case 1:
                    ClientService.newOrder();
                    clientMenu();
                case 2 :
                    System.out.println("Что бы отменить заказ обратитесь к менеджеру");
                    clientMenu();
                case 3 :
                    MainMenu.mainMenu();
            }
        }
    }
}
