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
import java.util.ArrayList;
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
            Query<Station> query = stationSession.createQuery("from Station", Station.class);
            List<Station> resultList = query.getResultList();
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

    public static List<Petrol> getAllPetrol() {
        Transaction transaction = petrolSession.beginTransaction();
        try {
            Query<Petrol> fromPetrol = petrolSession.createQuery("from Petrol", Petrol.class);
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

    public static boolean join(Station station, Petrol... petrol) {
        try {
            for (Petrol value : petrol) {
                DBConnector.getStatement().executeUpdate
                        (String.format(SQLQuery.forJoining, station.getId(), value.getId()));
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("->->->Ошибка метода AdminDAO.joining()<-<-<-");
            return false;
        }
    }


    public static List<Petrol> showJoin(Station station){
        List<Petrol> rtnList = new ArrayList<>();
        try{
            final ResultSet resultSet = DBConnector.getStatement().executeQuery
                    (String.format(SQLQuery.showPetrolByStation,station.getId()));
            while(resultSet.next()){
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

    public static void deletePetrol(Station s,int idPetrol){
        try{
            DBConnector.getStatement().executeUpdate(String.format(SQLQuery.deletePetrol,s.getId(),idPetrol));
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
