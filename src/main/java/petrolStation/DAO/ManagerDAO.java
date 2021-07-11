package petrolStation.DAO;

import com.google.protobuf.DescriptorProtos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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


    //    public static boolean updatePrice(int price, String nameStation) {
//        try (Statement statement = DBConnector.getConnection().createStatement()) {
//            statement.executeUpdate(String.format(SQLQuery.updatePrice, price, nameStation));
//            return true;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            System.err.println("Ошибка метода ManagerDAO.updatePrice()");
//            return false;
//        }
//    }

    public static boolean updatePrice(int price, String name) {
        try (PreparedStatement preparedStatement =
                     DBConnector.getConnection().prepareStatement
                             (SQLQuery.updatePrice)){
            preparedStatement.setInt(1,price);
            preparedStatement.setString(2,name);
            return true;
        }catch (SQLException ex){
            ex.printStackTrace();
            System.err.println("->->->Ошибка метода ManagerDAO.updatePrice()<-<-<-");
            return false;
        }
    }
}
