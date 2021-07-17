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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;

public class ManagerDAO {


    public static boolean updatePrice(int price, Petrol petrol) {
        try (Statement st = DBConnector.getConnection().createStatement()) {
            st.executeUpdate(String.format(SQLQuery.updatePrice, price, petrol.getName()));
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("->->->Ошибка метода ManagerDAO.updatePrice()<-<-<-");
            return false;
        }
    }

    public static boolean checkInt(int check) {
        if (check > 0) {
            return true;
        } else {
            return false;
        }
    }
}
