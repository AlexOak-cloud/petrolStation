package petrolStation.services;

import petrolStation.DAO.OrderDAO;
import petrolStation.console.Reader;
import petrolStation.model.Order;

import java.time.LocalDateTime;
import java.util.List;

public class OrderService {


    public static List<Order> showOrders() {
        final List<Order> allOrders = OrderDAO.getAllOrders();
        int number = 1;
        for (Order tmp : allOrders) {
            System.out.println(number +
                    ": " +
                    tmp.getPetrolName() +
                    " sum: " +
                    tmp.getSum() +
                    ", quantity: " +
                    tmp.getQuantity() +
                    ", date: " +
                    (tmp.getTime()));
            number++;
        }
        return allOrders;
    }
}
