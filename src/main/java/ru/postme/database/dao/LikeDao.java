package ru.postme.database.dao;

import ru.postme.database.model.Like;

import java.util.List;

public interface LikeDao {
    Long createLike(Like like);
    Like getLikeById(Long id);
    void deleteLike(Long id);
    List<Like> getAllLikes();
    List<Like> getAllUserLikes(String nickname);
    List<Like> getAllPostLikes(Long postId);
}
