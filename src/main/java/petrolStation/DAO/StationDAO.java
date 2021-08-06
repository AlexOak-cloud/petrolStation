package petrolStation.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import petrolStation.model.Station;
import petrolStation.util.HibernateConfig;

import java.util.Collections;
import java.util.List;

public class StationDAO<T extends Station> implements DAO<T> {


    public static final Session stationSession = HibernateConfig.getSessionStation();

    @Override
    public void create(T t) {
        Transaction transaction = stationSession.beginTransaction();
        try {
            stationSession.persist(t);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public List<T> getAll() {
        Transaction transaction = stationSession.beginTransaction();
        try {
            Query<Station> query = stationSession.createQuery
                    ("from Station", Station.class);
            List<T> resultList = (List<T>) query.getResultList();
            transaction.commit();
            return resultList;
        } catch (Exception ex) {
            transaction.rollback();
            return Collections.emptyList();
        }
    }

    @Override
    public void delete(T t) {
        Transaction transaction = stationSession.beginTransaction();
        try {
            stationSession.delete(t);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public T getById(int id) {
        Transaction transaction = stationSession.beginTransaction();
        try {
            final T rtnSession = (T) stationSession.get(Station.class, id);
            transaction.commit();
            return rtnSession;
        } catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
            return null;
        }
    }
}
