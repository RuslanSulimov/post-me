package ru.postme.database.dao.impl;

import jakarta.persistence.Query;
import org.hibernate.Session;
import ru.postme.database.dao.CommentDao;
import ru.postme.database.hibernate.HibernateUtil;
import ru.postme.database.model.Comment;
import ru.postme.database.model.Like;
import ru.postme.database.model.Post;

import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public Long createComment(Comment comment) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Long commentId = (Long) session.save(comment);
        session.getTransaction().commit();
        session.close();
        return commentId;
    }

    @Override
    public void updateComment(Comment comment) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        session.update(comment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Comment getCommentById(Long id) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Comment commentById = session.get(Comment.class, id);
        session.getTransaction().commit();
        session.close();
        return commentById;
    }

    @Override
    public void deleteComment(Long id) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        Comment deletingComment = (Comment) session.get(Comment.class, id);
        session.remove(deletingComment);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public List<Comment> getAllComments() {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        String hql = "SELECT u FROM Comment u";
        Query query = session.createQuery(hql);
        List<Comment> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }
    @Override
    public List<Comment> getAllUserComments(String nickname) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        String hql = "FROM Comment c WHERE c.user.nickname = :userNickname";
        Query query = session.createQuery(hql);
        query.setParameter("userNickname", nickname);
        List<Comment> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }
    @Override
    public List<Comment> getAllPostComments(Long postId) {
        Session session = HibernateUtil.openSession();
        session.beginTransaction();
        String hql = "FROM Comment c WHERE c.post.id = :postId";
        Query query = session.createQuery(hql);
        query.setParameter("postId", postId);
        List<Comment> results = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return results;
    }
}
