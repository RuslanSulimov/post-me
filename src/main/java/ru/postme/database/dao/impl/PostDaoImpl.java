package ru.postme.database.dao.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import ru.postme.database.dao.PostDao;
import ru.postme.database.hibernate.HibernateUtil;
import ru.postme.database.model.Post;
import ru.postme.database.model.User;

import java.util.List;

public class PostDaoImpl implements PostDao {

    @Override
    public Long createPost(Post post) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Long postId = (Long) session.save(post);
        session.getTransaction().commit();
        session.close();
        return postId;
    }

    @Override
    public void updatePost(Post post) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.update(post);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Post getPostById(Long id) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Post postById = session.get(Post.class, id);
        session.getTransaction().commit();
        session.close();
        return postById;
    }

    @Override
    public void deletePost(Long id) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Post deletingPost = (Post) session.get(Post.class, id);
        session.remove(deletingPost);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Post> getAllPosts() {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        String hql = "SELECT u FROM Post u";
        Query query = session.createQuery(hql);
        List<Post> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }
    @Override
    public List<Post> getAllPostsByNickname(String nickname) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        String hql = "FROM Post p WHERE p.user.nickname = :userNickname";
        Query query = session.createQuery(hql);
        query.setParameter("userNickname", nickname);
        List<Post> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }
}

