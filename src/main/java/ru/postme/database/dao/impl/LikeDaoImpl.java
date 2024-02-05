package ru.postme.database.dao.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import ru.postme.database.dao.LikeDao;
import ru.postme.database.hibernate.HibernateUtil;
import ru.postme.database.model.Comment;
import ru.postme.database.model.Like;
import ru.postme.database.model.Post;

import java.util.List;

public class LikeDaoImpl implements LikeDao {
    @Override
    public Long createLike(Like like) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Long likeId = (Long) session.save(like);
        session.getTransaction().commit();
        session.close();
        return likeId;
    }

    @Override
    public Like getLikeById(Long id) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Like likeById = session.get(Like.class, id);
        session.getTransaction().commit();
        session.close();
        return likeById;
    }

    @Override
    public void deleteLike(Long id) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Like deletingLike = session.get(Like.class, id);
        session.remove(deletingLike);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Like> getAllLikes() {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        String hql = "SELECT u FROM Like u";
        Query query = session.createQuery(hql);
        List<Like> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }
    @Override
    public List<Like> getAllUserLikes(String nickname) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        String hql = "FROM Like l WHERE l.user.nickname = :userNickname";
        Query query = session.createQuery(hql);
        query.setParameter("userNickname", nickname);
        List<Like> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }
    @Override
    public List<Like> getAllPostLikes(Long postId) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        String hql = "FROM Like l WHERE l.post.id = :postId";
        Query query = session.createQuery(hql);
        query.setParameter("postId", postId);
        List<Like> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }
}
