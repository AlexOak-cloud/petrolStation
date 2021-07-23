package petrolStation.services;

import petrolStation.DAO.OrderDAO;
import petrolStation.console.ManagerMenu;
import petrolStation.console.Reader;
import petrolStation.DAO.AdminDAO;
import petrolStation.DAO.ManagerDAO;
import petrolStation.model.Order;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.time.LocalDateTime;
import java.util.List;

public class ManagerService {


    public static void updatePetrolPrice() {
        final List<Petrol> allPetrol = AdminDAO.getAllPetrol();
        System.out.println(AdminService.showListPetrol(allPetrol));
        final int number = Reader.readInt
                ("Выберите номер топлива для изменения стоимости", 1,allPetrol.size()+1 );
        final int price = Reader.readInt("Введите новую стоимость");
        final Petrol petrol = allPetrol.get(number-1);
        ManagerDAO.updatePrice(price, petrol);
    }


    public static Petrol selectPetrol(List<Petrol> list) {
        return list.get(Reader.readInt("Введите номер топлива", 1, list.size() + 1)-1);
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
        final Station stationById = AdminService.getStationById();
        final List<Petrol> petrolList = AdminService.showJoin(stationById);
        final Petrol petrol = selectPetrol(petrolList);
        final int answer = Reader.readInt
                ("1: Ввести сумму для заправкм\n" +
                                "2: Ввести колличестов топлива для заправки",
                        1, 2);
        if (answer == 1) {
            final double sum = newOrderBySum(petrol);
            final Order order = new Order(petrol.getName(), sum, sum / petrol.getPrice(), LocalDateTime.now());
            OrderDAO.add(order);
            System.out.println("Успешно!");
            System.out.println("Чек: "+ order);
        } else if (answer == 2) {
            final double quantity = newOrderByQuantity(petrol);
            final Order order = new Order(petrol.getName(), quantity * petrol.getPrice(), quantity, LocalDateTime.now());
            OrderDAO.add(order);
            System.out.println("Успешно!");
            System.out.println("Чек: " + order);

        }
    }


    public static void deleteOrder() {
        final List<Order> orders = OrderService.showOrders();
        final int number = Reader.readInt
                ("Введите номер заказа для его удаления\n0: Назад", 0, orders.size() + 1);
        if(number == 0){
            ManagerMenu.managerMenu();
        }
        OrderDAO.deleteOrder(orders.get(number-1));
    }
}
