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
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

@Slf4j
public class AdminDAO {

    public static final Session stationSession = HibernateConfig.getSessionStation();
    public static final Session petrolSession = HibernateConfig.getSessionPetrol();

    public static boolean createStation(Station station) {
        Transaction transaction = stationSession.beginTransaction();
        try {
            stationSession.persist(station);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    public static List<Station> getAllStation() {
        Transaction transaction = stationSession.beginTransaction();
        try {
            Query query = stationSession.createQuery("from Station", Station.class);
            List<Station> resultList = (List<Station>) query.getResultList();
            transaction.commit();
            return resultList;
        } catch (Exception ex) {
            transaction.rollback();
            return Collections.emptyList();
        }
    }

    public static Station getStationById(int id) {
        Transaction transaction = stationSession.beginTransaction();
        try {
            Station station = stationSession.get(Station.class, id);
            transaction.commit();
            return station;
        } catch (Exception exception) {
            transaction.rollback();
            return new Station();
        }
    }

    public static boolean deleteStation(Station station) {
        Transaction transaction = stationSession.beginTransaction();
        try {
            stationSession.delete(station);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            return false;
        }
    }

    public static boolean createPetrol(Petrol petrol) {
        Transaction transaction = stationSession.beginTransaction();
        try {
            petrolSession.persist(petrol);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public static List<Petrol> getAllPetrol() {
        Transaction transaction = petrolSession.beginTransaction();
        try {
            Query<Petrol> from_petrol = petrolSession.createQuery("from Petrol", Petrol.class);
            List<Petrol> resultList = from_petrol.getResultList();
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

    public static boolean deletePetrol(Petrol petrol) {
        Transaction transaction = petrolSession.beginTransaction();
        try {
            petrolSession.delete(petrol);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean joining(Station station, Petrol... petrol) {
        try {
            Statement statement = DBConnector.getConnection().createStatement();
            for (int i = 0; i < petrol.length; i++) {
                statement.executeUpdate(String.format(SQLQuery.forJoining, petrol[i].getId(), station.getId()));
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("->->->Ошибка метода AdminDAO.joining()<-<-<-");
            return false;

        }
    }

    public static String showJoinByStations(Station stations) {
        StringBuilder builder = new StringBuilder();
        try {
            Statement statement = DBConnector.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(SQLQuery.showJoining, stations.getId()));
            System.out.println(stations + ":\n");
            while (resultSet.next()) {
                if(resultSet.getString(2) == null ) continue;
                builder.append("name: ").
                        append(resultSet.getString(2)).
                        append(" price: ").
                        append(resultSet.getString(3)).
                        append(" ");
            }
            return builder.toString();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("->->->Ошибка метода AdminDAO.showJoinByStations()<-<-<-");
            return builder.toString();
        }
    }

    public static boolean deleteAllPetrol(int password) {
        try {
            if (password == 123) {
                Statement statement = DBConnector.getConnection().createStatement();
                statement.executeUpdate(SQLQuery.deleteAllPetrol);
                return true;
            } else {
                System.err.println("Неверный пароль");
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("->->->Ошибка метода AdminDAO.deleteAllPetrol()<-<-<-");
            return false;
        }
    }
}
