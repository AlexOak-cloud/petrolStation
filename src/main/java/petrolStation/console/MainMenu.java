package petrolStation.console;

import petrolStation.util.DBConnector;

import java.io.IOException;
import java.sql.SQLException;

public class MainMenu {

    public static void mainMenu() {
        System.out.println
                ("1: Администратор\n2: Менеджер\n3: Клиент\n0: Выход");
        final int answer = Reader.readInt();
        while (true) {
            switch (answer) {
                case 1:
                    AdminMenu.adminMenu();
                    mainMenu();
                case 2:
                    ManagerMenu.managerMenu();
                    mainMenu();
                case 3:
                    ClientMenu.clientMenu();
                    mainMenu();
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
