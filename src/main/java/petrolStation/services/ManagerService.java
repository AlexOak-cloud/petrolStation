package petrolStation.services;

import petrolStation.DAO.OrderDAO;
import petrolStation.DAO.PetrolDAO;
import petrolStation.console.ManagerMenu;
import petrolStation.console.Reader;
import petrolStation.model.Order;
import petrolStation.model.Petrol;
import petrolStation.model.Station;
import petrolStation.serialization.Repository;
import petrolStation.serialization.Serialazer;

import java.time.LocalDateTime;
import java.util.List;

import static petrolStation.services.AdminService.showListStations;

public class ManagerService {

    public static void updatePetrolPrice() {
        List<Petrol> allPetrol = PetrolDAO.action().getAll();
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
        PetrolDAO.updatePrice(price, petrol);
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
        Order order;
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
            order = new Order(petrol.getName(),
                    sum,
                    sum / petrol.getPrice(),
                    LocalDateTime.now());
            OrderDAO.action().create(order);
            Serialazer.action().write(order, Repository.getFileOrder());
            System.out.println("Успешно!");
            System.out.println("Чек: " + order);
        } else if (answer == 2) {
            final double quantity = newOrderByQuantity(petrol);
            order = new Order(petrol.getName(),
                    quantity * petrol.getPrice(),
                    quantity,
                    LocalDateTime.now());
            OrderDAO.action().create(order);
            Serialazer.action().write(order, Repository.getFileOrder());
            System.out.println("Успешно!");
            System.out.println("Чек: " + order);

        }
    }

    public static Station selectStation() {
        final List<Station> allStations = AdminService.getAll();
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
        Order order = orders.get(number - 1);
        OrderDAO.action().delete(order);
        Serialazer.action().write(order,Repository.getFileOrder());
    }
}
