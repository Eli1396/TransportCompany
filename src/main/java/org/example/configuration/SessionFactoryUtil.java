package org.example.configuration;

import org.example.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class SessionFactoryUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                configuration.setProperties(getConfigurationProperties());
                setAnnotatedClassesToConfiguration(configuration);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static void setAnnotatedClassesToConfiguration(Configuration configuration) {
       configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Client.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Vehicle.class);
        configuration.addAnnotatedClass(NewOrder.class);
        configuration.addAnnotatedClass(Receipt.class);
        configuration.addAnnotatedClass(Skill.class);
    }

    private static Properties getConfigurationProperties() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/transportcompany?createDatabaseIfNotExist=true&useSSL=true");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "admin1234");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.STORAGE_ENGINE, "innodb");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        return settings;
    }
}
