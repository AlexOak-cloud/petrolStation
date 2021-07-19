package petrolStation.testSpace;

import petrolStation.Console.AdminMenu;
import petrolStation.DAO.AdminDAO;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.util.List;

public class TestSpace {
    public static void main(String[] args) {
        AdminMenu.adminMenu();

    }


    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }
}
