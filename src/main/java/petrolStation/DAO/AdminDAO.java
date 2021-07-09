package petrolStation.DAO;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import petrolStation.model.Petrol;
import petrolStation.model.Station;
import petrolStation.util.HibernateConfig;

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

    public static boolean createPetrol(Petrol petrol){
        Transaction transaction = stationSession.beginTransaction();
        try{
            petrolSession.persist(petrol);
            transaction.commit();
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
    public static List<Petrol> getAll(){
        Transaction transaction = petrolSession.beginTransaction();
        try{
            Query<Petrol> from_petrol = petrolSession.createQuery("from Petrol", Petrol.class);
            List<Petrol> resultList = from_petrol.getResultList();
            transaction.commit();
            return resultList;
        } catch (Exception ex){
            ex.printStackTrace();
            return Collections.emptyList();
        }
    }
    public static Petrol getPetrolById(int id){
        Transaction transaction = petrolSession.beginTransaction();
        try{
            Petrol petrol = petrolSession.get(Petrol.class, id);
            transaction.commit();
            return petrol;
        } catch (Exception ex){
            ex.printStackTrace();
            return new Petrol();
        }
    }

    public static boolean deletePetrol(Petrol petrol){
        Transaction transaction = petrolSession.beginTransaction();
        try{
            petrolSession.delete(petrol);
            transaction.commit();
            return true;
        } catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }


}