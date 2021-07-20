package petrolStation.testSpace;

import petrolStation.util.DBConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TestSpace {
    public static void main(String[] args) {
        addOrders("92",12,LocalDateTime.now());




    }
    public static void addOrders(String name, int sum, LocalDateTime time){
        try {
            final PreparedStatement preparedStatement = DBConnector.getConnection().prepareStatement
                    ("insert into orders(petrol_name, SUM, order_time) values(?,?,?)");
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,sum);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }


    public static <T> String showList(List<T> list) {
        StringBuilder sb = new StringBuilder();
        for (Object tmp : list) {
            sb.append(tmp).append("\n");
        }
        return sb.toString();
    }

}
