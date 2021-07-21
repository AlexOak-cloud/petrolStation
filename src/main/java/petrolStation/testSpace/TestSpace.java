package petrolStation.testSpace;

import petrolStation.console.MainMenu;
import petrolStation.util.DBConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TestSpace {
    public static void main(String[] args) {
        MainMenu.mainMenu();




    }

    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }

}
