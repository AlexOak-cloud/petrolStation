package petrolStation.DAO;

import com.google.protobuf.DescriptorProtos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import petrolStation.model.Petrol;
import petrolStation.model.Station;
import petrolStation.util.DBConnector;
import petrolStation.util.HibernateConfig;
import petrolStation.util.SQLQuery;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class ManagerDAO {


    public static void updatePrice(int price, Petrol petrol) {
        try {
            DBConnector.getStatement().executeUpdate(String.format(SQLQuery.updatePrice, price, petrol.getName()));
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("->->->Ошибка метода ManagerDAO.updatePrice()<-<-<-");
        }
    }

    public static int calcPrice(int money, String name) {
        try {
            final ResultSet resultSet = DBConnector.getStatement().executeQuery
                    (String.format(SQLQuery.petrolByName, name));
       while(resultSet.next()){

       }
            return price * money;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }


    }
}
