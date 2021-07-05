package petrolStation.DAO;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import petrolStation.model.Station;
import petrolStation.util.HibernateConfig;

import java.util.Collections;
import java.util.List;

@Slf4j
public class AdminDAO {

    public static final Session session = HibernateConfig.getSession();

    public static boolean createStation(Station station) {
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(station);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public static List<Station> getAll() {
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from Station", Station.class);
            List<Station> resultList = (List<Station>) query.getResultList();
            transaction.commit();
            return resultList;
        } catch (Exception ex) {
            transaction.rollback();
            return Collections.emptyList();
        }
    }

    public static Station getById(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            Station station = session.get(Station.class, id);
            transaction.commit();
            return station;
        } catch (Exception exception) {
            transaction.rollback();
            return new Station();
        }
    }

    public static boolean delete(Station station) {
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(station);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            return false;
        }
    }

    public static void main(String[] args) {
        Station station = new Station();

        createStation(station);
    }
}
