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
import petrolStation.model.Petrol;
import petrolStation.model.Station;
import petrolStation.util.DBConnector;
import petrolStation.util.HibernateConfig;
import petrolStation.util.SQLQuery;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class PetrolDAO {

    public static final Session petrolSession = HibernateConfig.getSessionPetrol();


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

    public static void updatePrice(int price, Petrol petrol) {
        try {
            DBConnector.getStatement().executeUpdate(String.format(SQLQuery.updatePrice, price, petrol.getName()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
