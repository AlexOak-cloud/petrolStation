package petrolStation.util;


import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import petrolStation.model.Station;

import java.io.IOException;
import java.util.Properties;

public class HibernateConfig {

    public static Session getSession() {
        Configuration configuration = new Configuration();
        configuration.addProperties(getProps());
        configuration.addAnnotatedClass(Station.class);
        return configuration.buildSessionFactory().openSession();
    }


    private static Properties getProps() {
        Properties properties = new Properties();
        try {
            properties.load(HibernateConfig.class.getClassLoader().
                    getResourceAsStream("hibernate.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }
}
