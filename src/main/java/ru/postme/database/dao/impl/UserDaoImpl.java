package ru.postme.database.dao.impl;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.Root;
import ru.postme.database.dao.UserDao;
import ru.postme.database.model.User;
import ru.postme.database.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

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
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public User getUserById(Long id) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        User userById = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return userById;
    }

    @Override
    public void deleteUser(Long id) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        User deletingUser = (User) session.get(User.class, id);
        session.remove(deletingUser);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<User> getUserByNickname(String nickname) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        String hql = "SELECT u FROM User u WHERE nickname = :userNickname";
        Query query = session.createQuery(hql);
        query.setParameter("userNickname", nickname);
        List<User> foundUsers = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return foundUsers;

    }

    @Override
    public List<User> getAllUsers() {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        String hql = "SELECT u FROM User u";
        Query query = session.createQuery(hql);
        List<User> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }
}
