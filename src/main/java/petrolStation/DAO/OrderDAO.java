package petrolStation.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import petrolStation.model.Order;
import petrolStation.util.HibernateConfig;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OrderDAO {

    public static final Session session = HibernateConfig.getSessionOrder();

    public static void add(Order order) {
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(order);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    public static List<Order> getAllOrders() {
        Transaction transaction = session.beginTransaction();
        try {
            final Query<Order> orderQuery = session.createQuery("from Order", Order.class);
            return orderQuery.getResultList();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static Order getOrderById(int id){
        Transaction transaction = session.beginTransaction();
        try{
            final Order order = session.get(Order.class, id);
            transaction.commit();
            return order;
        } catch (Exception ex){
            transaction.rollback();
            ex.printStackTrace();
            return new Order();
        }
    }
    public static void deleteOrder(Order order){
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(order);
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
            ex.printStackTrace();
        }
    }
}
