package ru.postme.service;

import org.springframework.stereotype.Service;
import ru.postme.database.dao.impl.CommentDaoImpl;
import ru.postme.database.model.Comment;
import java.util.List;

@Service
public class CommentService {

    private final CommentDaoImpl commentDao;

    public CommentService (CommentDaoImpl commentDao) {this.commentDao = commentDao;}

    public Long createComment(Comment comment) {
        return commentDao.createComment(comment);
    }

    public void updateComment(Comment comment) {
        commentDao.updateComment(comment);
    }

    public Comment getCommentById(Long id) {
        return commentDao.getCommentById(id);
    }

    public void deleteComment(Long id) {
        commentDao.deleteComment(id);
    }

    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
    }

    public List<Comment> getAllUserComments(String nickname) {
        return commentDao.getAllUserComments(nickname);
    }

    public List<Comment> getAllPostComments(Long postId) {
        return commentDao.getAllPostComments(postId);
    }
}
