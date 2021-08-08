package petrolStation.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import petrolStation.model.Station;
import petrolStation.serialization.Serialazer;
import petrolStation.util.HibernateConfig;

import java.util.Collections;
import java.util.List;

public class StationDAO<T extends Station> implements DAO<T> {


    public static final Session session = HibernateConfig.getSessionStation();
    private static final StationDAO<Station> stationDAO = new StationDAO<>();

    public static StationDAO<Station> action(){
        return stationDAO;
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
            Query<Station> query = session.createQuery
                    ("from Station", Station.class);
            List<Station> resultList =  query.getResultList();
            transaction.commit();
            return (List<T>) resultList;
        } catch (Exception ex) {
            transaction.rollback();
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
            ex.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public T getById(int id) {
        Transaction transaction = session.beginTransaction();
        try {
            final Station station = session.get(Station.class, id);
            transaction.commit();
            return (T) station;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return (T) new Station();
        }
    }
}
