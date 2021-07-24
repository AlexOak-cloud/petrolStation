package petrolStation.console;

import petrolStation.util.DBConnector;

import java.io.IOException;
import java.sql.SQLException;

public class MainMenu {

    public static void start() {
        System.out.println
                ("1: Администратор\n2: Менеджер\n3: Клиент\n0: Выход");
        final int answer = Reader.readInt();
        while (true) {
            switch (answer) {
                case 1:
                    AdminMenu.adminMenu();
                    start();
                case 2:
                    ManagerMenu.managerMenu();
                    start();
                case 3:
                    ClientMenu.clientMenu();
                    start();
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
