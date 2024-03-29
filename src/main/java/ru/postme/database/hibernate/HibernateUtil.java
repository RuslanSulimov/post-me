package ru.postme.database.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Инициализация SessionFactory не удалась: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static <T> T executeInTransaction(TransactionCallback<T> callback) {
        try (Session session = HibernateUtil.openSession()) {
            session.beginTransaction();
            T result = callback.execute(session);
            session.getTransaction().commit();
            session.close();
            return result;
        }
    }

    public interface TransactionCallback<T> {
        T execute(Session session);
    }
}
