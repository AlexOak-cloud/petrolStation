package petrolStation.util;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public class DBProps {


    private static Properties PROPERTIES;

    static{
       final Properties properties = new Properties();
        try {
            properties.load(DBProps.class.getClassLoader().getResourceAsStream("db.properties"));
            PROPERTIES = properties;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Optional<String> getValue(String key) {
        return Optional.ofNullable(PROPERTIES.getProperty(key));
    }
}
