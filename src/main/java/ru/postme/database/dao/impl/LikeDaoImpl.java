package ru.postme.database.dao.impl;

import org.springframework.stereotype.Repository;
import ru.postme.database.dao.LikeDao;
import ru.postme.database.hibernate.HibernateUtil;
import ru.postme.database.model.Like;

import java.util.List;

@Repository
public class LikeDaoImpl implements LikeDao {
    @Override
    public Long createLike(Like like) {
        return HibernateUtil.executeInTransaction(session -> (Long) session.save(like));
    }

    @Override
    public Like getLikeById(Long id) {
        return HibernateUtil.executeInTransaction(session -> session.get(Like.class, id));
    }

    @Override
    public void deleteLike(Long id) {
        HibernateUtil.executeInTransaction(session -> {
            Like deletingLike = session.get(Like.class, id);
            session.remove(deletingLike);
            return null;
        });
    }

    @Override
    public List<Like> getAllLikes() {
        return HibernateUtil.executeInTransaction(session -> session
                .createQuery("SELECT u FROM Like u")
                .getResultList());
    }

    @Override
    public List<Like> getAllUserLikes(String nickname) {
        return HibernateUtil.executeInTransaction(session -> session
                .createQuery("FROM Like l WHERE l.user.nickname = :userNickname")
                .setParameter("userNickname", nickname)
                .getResultList());
    }

    @Override
    public List<Like> getAllPostLikes(Long postId) {
        return HibernateUtil.executeInTransaction(session -> session
                .createQuery("FROM Like l WHERE l.post.id = :postId")
                .setParameter("postId", postId)
                .getResultList());
    }
}
