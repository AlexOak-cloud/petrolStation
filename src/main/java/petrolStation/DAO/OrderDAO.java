package petrolStation.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import petrolStation.model.Order;
import petrolStation.util.HibernateConfig;

import java.util.Collections;
import java.util.List;

public class OrderDAO<T extends Order> implements DAO<T> {

    private static final Session session = HibernateConfig.getSessionOrder();

    private static final OrderDAO<Order> orderDAO = new OrderDAO<>();

    public static OrderDAO<Order> action(){
        return orderDAO;
    }

    @Override
    public void create(T t) {
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(t);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public List<T> getAll() {
        Transaction transaction = session.beginTransaction();
        try {
            final Query<Order> orderQuery = session.createQuery("from Order", Order.class);
            transaction.commit();
            return (List<T>) orderQuery.getResultList();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public void delete(T t) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(t);
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
        }
    }

    @Override
    public T getById(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            final Order order = session.get(Order.class, id);
            transaction.commit();
            return (T) order;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
            return (T) new Order();
        }
    }
}
