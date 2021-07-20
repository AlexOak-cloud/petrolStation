package petrolStation.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import petrolStation.model.Order;
import petrolStation.model.Petrol;
import petrolStation.model.Station;

import java.io.IOException;
import java.util.Properties;

public class HibernateConfig {

    public static Session getSessionStation() {
        Configuration configuration = new Configuration();
        configuration.addProperties(getProps());
        configuration.addAnnotatedClass(Station.class);
        return configuration.buildSessionFactory().openSession();
    }
    public static Session getSessionPetrol() {
        Configuration configuration = new Configuration();
        configuration.addProperties(getProps());
        configuration.addAnnotatedClass(Petrol.class);
        return configuration.buildSessionFactory().openSession();
    }
    public static Session getSessionOrder() {
        Configuration configuration = new Configuration();
        configuration.addProperties(getProps());
        configuration.addAnnotatedClass(Order.class);
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
