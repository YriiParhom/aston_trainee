package servicebyservletshibernamte.util;

import javassist.ClassClassPath;
import javassist.ClassPath;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public SessionFactory getSessionFactory() {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml");

        return configuration.buildSessionFactory();
    }
}
