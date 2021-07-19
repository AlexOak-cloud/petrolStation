package petrolStation.Console;

public class MainMenu {

    public static void mainMenu() {
        System.out.println(MainMenuMassages.mainMenu);
        final int answer = Reader.readInt();
        while (answer != 0) {
            switch (answer) {
                case 1:
                    AdminMenu.adminMenu();
                case 2:



                case 0:
            }
        }


    }


}
