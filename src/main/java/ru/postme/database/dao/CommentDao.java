package ru.postme.database.dao;

import ru.postme.database.model.Comment;

import java.util.List;

public interface CommentDao {
    Long createComment(Comment comment);

    void updateComment(Comment comment);

    Comment getCommentById(Long id);

    void deleteComment(Long id);

    List<Comment> getAllComments();

    List<Comment> getAllUserComments(String nickname);
    List<Comment> getAllPostComments(Long id);
}