package petrolStation.DAO;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import petrolStation.model.Petrol;
import petrolStation.model.Station;
import petrolStation.util.DBConnector;
import petrolStation.util.HibernateConfig;
import petrolStation.util.SQLQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class AdminDAO {

    public static final Session stationSession = HibernateConfig.getSessionStation();
    public static final Session petrolSession = HibernateConfig.getSessionPetrol();


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


    public static List<Petrol> getAllPetrol() {
        Transaction transaction = petrolSession.beginTransaction();
        try {
            Query<Petrol> fromPetrol = petrolSession.createQuery
                    ("from Petrol", Petrol.class);
            List<Petrol> resultList = fromPetrol.getResultList();
            transaction.commit();
            return resultList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }


    public static Petrol getPetrolById(int id) {
        Transaction transaction = petrolSession.beginTransaction();
        try {
            Petrol petrol = petrolSession.get(Petrol.class, id);
            transaction.commit();
            return petrol;
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Petrol();
        }
    }


    public static void join(Station station, Petrol petrol) {
        try {
            DBConnector.getStatement().executeUpdate
                    (String.format(SQLQuery.forJoining, station.getId(), petrol.getId()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public static List<Petrol> showJoin(Station station) {
        List<Petrol> rtnList = new ArrayList<>();
        try {
            final ResultSet resultSet = DBConnector.getStatement().executeQuery
                    (String.format(SQLQuery.showPetrolByStation, station.getId()));
            while (resultSet.next()) {
                Petrol p = new Petrol(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3));
                rtnList.add(p);
            }
            return rtnList;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return Collections.emptyList();
        }
    }



    public static void deletePetrol(Station s, int idPetrol) {
        try {
            DBConnector.getStatement().executeUpdate
                    (String.format(SQLQuery.deletePetrol, s.getId(), idPetrol));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
