package petrolStation.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import petrolStation.model.Station;
import petrolStation.util.HibernateConfig;

import java.util.Collections;
import java.util.List;

public class StationDAO {

    public static final Session stationSession = HibernateConfig.getSessionStation();
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(StationDAO.class);

    public static void createStation(Station station) {
        Transaction transaction = stationSession.beginTransaction();
        try {
            stationSession.persist(station);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
    }


    public static List<Station> getAllStation() {
        Transaction transaction = stationSession.beginTransaction();
        try {
            Query<Station> query = stationSession.createQuery
                    ("from Station", Station.class);
            List<Station> resultList = query.getResultList();
            transaction.commit();
            return resultList;
        } catch (Exception ex) {
            transaction.rollback();
            return Collections.emptyList();
        }
    }

    public static void deleteStation(Station station) {
        Transaction transaction = stationSession.beginTransaction();
        try {
            stationSession.delete(station);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        }
    }
}
