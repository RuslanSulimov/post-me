package ru.postme.database.dao.impl;

import ru.postme.database.dao.CommentDao;
import ru.postme.database.hibernate.HibernateUtil;
import ru.postme.database.model.Comment;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public Long createComment(Comment comment) {
        return HibernateUtil.executeInTransaction(session -> (Long) session.save(comment));
    }

    @Override
    public void updateComment(Comment comment) {
        HibernateUtil.executeInTransaction(session -> {
            session.update(comment);
            return null;
        });
    }

    @Override
    public Comment getCommentById(Long id) {
        return HibernateUtil.executeInTransaction(session -> session.get(Comment.class, id));
    }

    @Override
    public void deleteComment(Long id) {
        HibernateUtil.executeInTransaction(session -> {
            Comment deletingComment = (Comment) session.get(Comment.class, id);
            session.remove(deletingComment);
            return null;
        });
    }

    @Override
    public List<Comment> getAllComments() {
        return HibernateUtil.executeInTransaction(session -> session
                .createQuery("SELECT u FROM Comment u")
                .getResultList());
    }
    @Override
    public List<Comment> getAllUserComments(String nickname) {
        return HibernateUtil.executeInTransaction(session -> session
                .createQuery("FROM Comment c WHERE c.user.nickname = :userNickname")
                .setParameter("userNickname", nickname)
                .getResultList());
    }
    @Override
    public List<Comment> getAllPostComments(Long postId) {
        return HibernateUtil.executeInTransaction(session -> session
                .createQuery("FROM Comment c WHERE c.post.id = :postId")
                .setParameter("postId", postId)
                .getResultList());
    }
}
