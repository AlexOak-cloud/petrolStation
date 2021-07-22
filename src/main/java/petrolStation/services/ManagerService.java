package petrolStation.services;

import petrolStation.DAO.OrderDAO;
import petrolStation.console.Reader;
import petrolStation.DAO.AdminDAO;
import petrolStation.DAO.ManagerDAO;
import petrolStation.model.Order;
import petrolStation.model.Petrol;

import java.time.LocalDateTime;
import java.util.List;

public class ManagerService {


    public static void updatePetrolPrice() {
        final List<Petrol> allPetrol = AdminDAO.getAllPetrol();
        System.out.println(AdminService.showListPetrol(allPetrol));
        final int id = Reader.readInt
                ("Выберите номер топлива для изменения стоимости", 1,allPetrol.size()+1 );
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


    public static int newOrderBySum(Petrol petrol) {
        final int sum = Reader.readInt("Введите сумму для заправки");
        System.out.println("Колличество топлива = " +
                sum / petrol.getPrice() + "л");
        return sum;
    }


    public static int newOrderByQuantity(Petrol petrol) {
        final int quantity = Reader.readInt
                ("Введите колличество топлива для завпраки (л)");
        System.out.println("Успешно: Сумма к оплате " +
                petrol.getPrice() + quantity + " р");
        return quantity;
    }


    public static void newOrder() {
        final Petrol petrol = selectPetrol();
        final int answer = Reader.readInt
                ("1: Ввести сумму для заправкм\n" +
                                "2: Ввести колличестов топлива для заправки",
                        1, 2);
        if (answer == 1) {
            final double sum = newOrderBySum(petrol);
            OrderDAO.add(new Order(petrol.getName(), sum, sum / petrol.getPrice(), LocalDateTime.now()));
        } else if (answer == 2) {
            final double quantity = newOrderByQuantity(petrol);
            OrderDAO.add(new Order(petrol.getName(), quantity * petrol.getPrice(), quantity, LocalDateTime.now()));
        }
    }


    public static void deleteOrder() {
        final List<Order> orders = OrderService.showOrders();
        final int number = Reader.readInt
                ("Введите номер заказа для его удаления", 1, orders.size() + 1);
        OrderDAO.deleteOrder(orders.get(number-1));
    }
}
