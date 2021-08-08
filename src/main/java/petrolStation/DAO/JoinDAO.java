/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import petrolStation.model.Join;
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


public class JoinDAO<T extends Join> implements DAO<T> {

    private static final Session session = HibernateConfig.getSessionJoin();

    private static final JoinDAO<Join> joinDAO = new JoinDAO<>();

    public static JoinDAO<Join> action() {
        return joinDAO;
    }

    @Override
    public  void create(T t) {
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(t);
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public List<T> getAll(){
        Transaction transaction = session.beginTransaction();
        try{
            Query query = session.createQuery("from Join",Join.class);
            List<Join> rtnList = query.getResultList();
            transaction.commit();
            return (List<T>) rtnList;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
            return Collections.emptyList();
        }
    }

    @Override
    public void delete(T t) {
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(t);
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
        }
    }

    @Override
    public T getById(int id) {
        Transaction transaction = session.beginTransaction();
        try{
            final Join join = session.get(Join.class, id);
            transaction.commit();
            return (T) join;
        }catch (Exception ex){
            ex.printStackTrace();
            transaction.rollback();
            return (T) new Join();
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
