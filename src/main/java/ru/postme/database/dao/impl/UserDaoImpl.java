package ru.postme.database.dao.impl;

import ru.postme.database.dao.UserDao;
import ru.postme.database.model.User;
import ru.postme.database.hibernate.HibernateUtil;
import org.hibernate.Session;
public class UserDaoImpl implements UserDao {
    @Override
    public Long createUser(User user) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Long userId = (Long) session.save(user);
        session.getTransaction().commit();
        session.close();
        return userId;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
