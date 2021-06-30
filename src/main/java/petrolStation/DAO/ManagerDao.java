package petrolStation.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import petrolStation.model.Station;
import petrolStation.util.HibernateConfig;

import java.util.Collections;
import java.util.List;

public class ManagerDao {

    public static final Session session = HibernateConfig.getSession(Station.class);


    public static boolean addStation(Station station) {
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(station);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public static List<Station> showAll() {
        Transaction transaction = session.beginTransaction();
        try {
            Query<Station> stations = session.createQuery("from Station", Station.class);
            List<Station> list = stations.getResultList();
            transaction.commit();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return Collections.emptyList();
        }
    }

    public static Station getStation(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            Station station = session.get(Station.class, id);
            transaction.commit();
            return station;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return new Station();
        }
    }


    public static boolean deleteStation(Station station) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(station);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public static boolean updateStation(Station station) {
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(station);
            transaction.commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
}
