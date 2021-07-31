/*
 * Copyright (c) 2021. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package petrolStation.DAO;

import petrolStation.model.Petrol;
import petrolStation.model.Station;
import petrolStation.util.DBConnector;
import petrolStation.util.SQLQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JoinDAO {



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

    public static void updatePrice(int price, Petrol petrol) {
        try {
            DBConnector.getStatement().executeUpdate(String.format(SQLQuery.updatePrice, price, petrol.getName()));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
