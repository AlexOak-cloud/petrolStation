package petrolStation.services;

import petrolStation.DAO.OrderDAO;
import petrolStation.console.Reader;
import petrolStation.model.Order;

import java.util.List;

public class OrderService {


    public static void showOrders(){
        final List<Order> allOrders = OrderDAO.getAllOrders();
        int number = 1;
        for(Order tmp: allOrders){
            System.out.println(number +
                    ": " +
                    tmp.getPetrolName() +
                    " sum: " +
                    tmp.getSum() +
                    ", date: " +
                    (tmp.getTime()));
            number++;
        }
    }

    public static void deleteOrder(){
        showOrders();
        final List<Order> allOrders = OrderDAO.getAllOrders();
        final int number = Reader.readInt("Введите число для удаления заказа",1,allOrders.size()+1);
        OrderDAO.deleteOrder(OrderDAO.getOrderById(allOrders.get(number + 1).getId()));
    }

    public static void saveOrder(Order order){
        OrderDAO.add(order);
    }
}
