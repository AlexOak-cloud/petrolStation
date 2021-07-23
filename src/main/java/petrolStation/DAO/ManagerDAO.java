package petrolStation.DAO;

import petrolStation.model.Petrol;
import petrolStation.util.DBConnector;
import petrolStation.util.SQLQuery;

import java.sql.SQLException;

public class ManagerDAO {


    public static void updatePrice(int price, Petrol petrol) {
        try {
            DBConnector.getStatement().executeUpdate(String.format(SQLQuery.updatePrice, price, petrol.getName()));
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("->->->Ошибка метода ManagerDAO.updatePrice()<-<-<-");
        }
    }
}

