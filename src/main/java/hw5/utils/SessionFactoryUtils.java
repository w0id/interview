package hw5.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtils {
    private static volatile SessionFactory factory;

    public synchronized static void init() {
        if (factory == null) {
            factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
        }
    }

    public SessionFactoryUtils() {
        System.out.println(this);
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    public void shutdown() {
        if (factory != null) {
            factory.close();
        }
    }
}
