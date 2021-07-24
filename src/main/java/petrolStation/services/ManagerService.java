package petrolStation.services;

import petrolStation.DAO.OrderDAO;
import petrolStation.console.AdminMenu;
import petrolStation.console.ManagerMenu;
import petrolStation.console.Reader;
import petrolStation.DAO.AdminDAO;
import petrolStation.DAO.ManagerDAO;
import petrolStation.model.Order;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.List;

import static petrolStation.services.AdminService.showListStations;

public class ManagerService {

    static DecimalFormat df = new DecimalFormat("#.##");


    public static void updatePetrolPrice() {
        List<Petrol> allPetrol = AdminDAO.getAllPetrol();
        System.out.println(AdminService.showListPetrol(allPetrol));
        final int number = Reader.readInt
                ("Выберите номер топлива для изменения стоимости\n0: Назад", 0, allPetrol.size() + 1);
        if (number == 0) {
            ManagerMenu.managerMenu();
        }
        final int price = Reader.readInt("Введите новую стоимость\n0: Назад");
        if (number == 0) {
            ManagerMenu.managerMenu();
        }
        Petrol petrol = allPetrol.get(number - 1);
        ManagerDAO.updatePrice(price, petrol);
    }


    public static Petrol selectPetrol(List<Petrol> list) {
        final int number = Reader.readInt("Введите номер топлива\n0: Назад", 0, list.size() + 1);
        if (number == 0) {
            ManagerMenu.managerMenu();
        }
        return list.get(number - 1);
    }


    public static int newOrderBySum(Petrol petrol) {
        final int sum = Reader.readInt("Введите сумму для заправки\n0: Назад");
        if (sum == 0) {
            ManagerMenu.managerMenu();
        }
        System.out.println("Колличество топлива = " +
                sum / petrol.getPrice() + "л");

        return sum;
    }


    public static int newOrderByQuantity(Petrol petrol) {
        final int quantity = Reader.readInt
                ("Введите колличество топлива для завпраки (л)\n0: Назад");
        if (quantity == 0) {
            ManagerMenu.managerMenu();
        }
        System.out.println("Успешно: Сумма к оплате " +
                petrol.getPrice() + quantity + " р");
        return quantity;
    }


    public static void newOrder() {
        final Station stationById = selectStation();
        final List<Petrol> petrolList = AdminService.showJoin(stationById);
        final Petrol petrol = selectPetrol(petrolList);
        final int answer = Reader.readInt
                ("1: Ввести сумму для заправкм\n" +
                                "2: Ввести колличестов топлива для заправки\n0: Назад",
                        0, 2);
        if (answer == 0) {
            ManagerMenu.managerMenu();
        } else if (answer == 1) {
            double sum = newOrderBySum(petrol);
            final Order order = new Order(petrol.getName(),
                    sum,
                    sum / petrol.getPrice(),
                    LocalDateTime.now());
            OrderDAO.add(order);

            System.out.println("Успешно!");
            System.out.println("Чек: " + order);
        } else if (answer == 2) {
            final double quantity = newOrderByQuantity(petrol);
            final Order order = new Order(petrol.getName(),
                    quantity * petrol.getPrice(),
                    quantity,
                    LocalDateTime.now());
            OrderDAO.add(order);
            System.out.println("Успешно!");
            System.out.println("Чек: " + order);

        }
    }

    public static Station selectStation() {
        final List<Station> allStations = AdminService.getAllStations();
        System.out.println(showListStations(allStations));
        final int idStation = Reader.readInt
                ("Выберите номер станции\n0: Назад", 0, allStations.size() + 1);
        if (idStation == 0) {
            ManagerMenu.managerMenu();
        }
        return allStations.get(idStation - 1);
    }


    public static void deleteOrder() {
        final List<Order> orders = OrderService.showOrders();
        final int number = Reader.readInt
                ("Введите номер заказа для его удаления\n0: Назад", 0, orders.size() + 1);
        if (number == 0) {
            ManagerMenu.managerMenu();
        }
        OrderDAO.deleteOrder(orders.get(number - 1));
    }
}
