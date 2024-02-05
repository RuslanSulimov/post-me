package ru.postme.database.dao.impl;

import ru.postme.database.dao.PostDao;
import ru.postme.database.hibernate.HibernateUtil;
import ru.postme.database.model.Post;
import java.util.List;

public class PostDaoImpl implements PostDao {

    @Override
    public Long createPost(Post post) {
        return HibernateUtil.executeInTransaction(session -> (Long) session.save(post));
    }

    @Override
    public void updatePost(Post post) {
        HibernateUtil.executeInTransaction(session -> {
            session.update(post);
            return null;
        });
    }

    @Override
    public Post getPostById(Long id) {
        return  HibernateUtil.executeInTransaction(session -> session.get(Post.class, id));
    }

    @Override
    public void deletePost(Long id) {
        HibernateUtil.executeInTransaction(session -> {
            Post deletingPost = session.get(Post.class, id);
            session.remove(deletingPost);
            return null;
        });
    }

    @Override
    public List<Post> getAllPosts() {
        return  HibernateUtil.executeInTransaction(session -> session
                .createQuery("SELECT u FROM Post u")
                .getResultList());
    }
    @Override
    public List<Post> getAllPostsByNickname(String nickname) {
        return  HibernateUtil.executeInTransaction(session -> session
                .createQuery("FROM Post p WHERE p.user.nickname = :userNickname")
                .setParameter("userNickname", nickname)
                .getResultList());
    }
}

