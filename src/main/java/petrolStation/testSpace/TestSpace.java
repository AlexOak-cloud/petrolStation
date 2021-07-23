package petrolStation.testSpace;

import petrolStation.DAO.AdminDAO;
import petrolStation.console.MainMenu;
import petrolStation.model.Petrol;
import petrolStation.services.AdminService;

import java.util.List;

public class TestSpace {
    public static void main(String[] args) {
        final List<Petrol> allPetrol = AdminDAO.getAllPetrol();
        System.out.println(AdminService.showListPetrol(allPetrol));
        MainMenu.mainMenu();
    }
}
