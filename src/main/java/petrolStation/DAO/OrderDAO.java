package petrolStation.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import petrolStation.model.Order;
import petrolStation.util.HibernateConfig;

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
            ex.printStackTrace();
            transaction.rollback();
        }
    }

    public static List<Order> getAllOrders() {
        Transaction transaction = session.beginTransaction();
        try {
            final Query<Order> orderQuery = session.createQuery("from Order", Order.class);
            transaction.commit();
            return orderQuery.getResultList();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return Collections.emptyList();
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
