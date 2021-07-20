package petrolStation.console;

import petrolStation.services.ClientService;

public class ClientMenu {

    public static void clientMenu(){
        System.out.println("1: Оформить заказ\n4: Отменить заказ");
        final int answer = Reader.readInt();
        while(answer != 0){
            switch (answer){
                case 1:
                    ClientService.newOrder();
            }



        }


    }
}
