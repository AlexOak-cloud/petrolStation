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

    public static Statement getStatement(){
        if(statement == null){
            try {
                statement = DBConnector.getConnection().createStatement();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        return statement;
    }
}