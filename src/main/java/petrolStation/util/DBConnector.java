package petrolStation.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

    private static Connection connection;
    private static Statement statement;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                String user = DBProps.getValue("user").orElse("root");
                String pass = DBProps.getValue("pass").orElse("root");
                String url = DBProps.getValue("url").orElse("localhost:3306");
                String db = DBProps.getValue("db").orElse("data");
                connection = DriverManager.getConnection
                        ("jdbc:mysql://" + url + "/" + db, user, pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

//        statement.executeUpdate("use data");

    /** Создание таблицы для хранения информации о заказах */
//        statement.executeUpdate("create table station_table(" +
//                "id int auto_increment primary key not null," +
//                "name varchar(30) not null," +
//                "quantity double not null," +
//                "orderSum int not null," +
//                "timeOrder datetime not null)");

    /**Создание таблицы для хранения данных о имеющихся колонках
     и стоимости бензина */
//        statement.executeUpdate("create table petrol_table(" +
//                "id int primary key not null auto_increment," +
//                "name varchar(30) not null," +
//                "price double not null)");
}


