package petrolStation.services;

import petrolStation.console.ManagerMenu;
import petrolStation.console.Reader;
import petrolStation.DAO.AdminDAO;
import petrolStation.DAO.ManagerDAO;
import petrolStation.model.Petrol;

import java.util.List;

public class ManagerService {


    public static void updatePetrolPrice() {
        System.out.println(AdminService.showList(AdminDAO.getAllPetrol()));
        final int id = Reader.readInt
                ("Выберите номер топлива для изменения стоимости", 18, 21);
        final int price = Reader.readInt("Введите новую стоимость");
        final Petrol petrol = AdminDAO.getPetrolById(id);
        ManagerDAO.updatePrice(price, petrol);
    }


    public static Petrol selectPetrol() {
        final List<Petrol> allPetrol = AdminDAO.getAllPetrol();
        int number = 1;
        for (Petrol tmp : allPetrol) {
            System.out.println(number + ": " + tmp.getName() +
                    ", price - " + tmp.getPrice());
            number++;
        }
        final int select = Reader.readInt
                ("Выберите номер топлива", 1, 4);
        switch (select) {
            case 1:
                return allPetrol.get(0);
            case 2:
                return allPetrol.get(1);
            case 3:
                return allPetrol.get(2);
            case 4:
                return allPetrol.get(3);
            default:
                return new Petrol();
        }
    }


    public static void newOrderBySum() {
        final Petrol petrol = selectPetrol();
        final int sum = Reader.readInt("Введите сумму для заправки");
        System.out.println("Колличество топлива = " +
                sum / petrol.getPrice() + "л");
    }


    public static void newOrderByQuantity() {
        final Petrol petrol = selectPetrol();
        final int quantity = Reader.readInt
                ("Введите колличество топлива для завпраки (л)");
        System.out.println("Сумма к оплате " +
                petrol.getPrice() + quantity + " р");
    }


    public static void newOrder() {
        final Petrol petrol = selectPetrol();
        final int answer = Reader.readInt
                ("1:Ввести сумму для заправкм\n" +
                                "2: Ввести колличестов топлива для заправки",
                        1, 2);
        switch (answer) {
            case 1:
                newOrderBySum();
            case 2:
                newOrderByQuantity();
        }
    }


    public static void cancallations() {
        ManagerMenu.managerMenu();
    }
}
