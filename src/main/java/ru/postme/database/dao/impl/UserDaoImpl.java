package ru.postme.database.dao.impl;

import ru.postme.database.dao.UserDao;
import ru.postme.database.hibernate.HibernateUtil;
import ru.postme.database.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public Long createUser(User user) {
        return HibernateUtil.executeInTransaction(session -> (Long) session.save(user));
    }

    @Override
    public void updateUser(User user) {
        HibernateUtil.executeInTransaction(session -> {
            session.update(user);
            return null;
        });
    }

    @Override
    public User getUserById(Long id) {
        return HibernateUtil.executeInTransaction(session -> session.get(User.class, id));
    }

    @Override
    public void deleteUser(Long id) {
        HibernateUtil.executeInTransaction(session -> {
            User deletingUser = session.get(User.class, id);
            session.remove(deletingUser);
            return null;
        });
    }

    @Override
    public User getUserByNickname(String nickname) {
        return (User) HibernateUtil.executeInTransaction(session -> session
                .createQuery("SELECT u FROM User u WHERE nickname = :userNickname")
                .setParameter("userNickname", nickname)
                .getSingleResult());

    }

    @Override
    public List<User> getAllUsers() {
        return HibernateUtil.executeInTransaction(session -> session
                .createQuery("SELECT u FROM User u")
                .getResultList());
    }
}
