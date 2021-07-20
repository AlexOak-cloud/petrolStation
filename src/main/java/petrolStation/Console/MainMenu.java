package petrolStation.Console;

import petrolStation.util.DBConnector;

import java.io.IOException;
import java.sql.SQLException;

public class MainMenu {

    public static void mainMenu() {
        System.out.println(MainMenuMassages.mainMenu);
        final int answer = Reader.readInt();
        while (answer != 0) {
            switch (answer) {
                case 1:
                    AdminMenu.adminMenu();
                case 2:
                    ManagerMenu.managerMenu();

                case 0:
                    try {
                        Reader.reader.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        DBConnector.getStatement().close();
                        DBConnector.getConnection().close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    System.exit(0);
            }
        }
    }
}
