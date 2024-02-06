package ru.postme.database.dao;

import ru.postme.database.model.Post;

import java.util.List;

public interface PostDao {
    Long createPost(Post post);

    void updatePost(Post post);

    Post getPostById(Long id);

    void deletePost(Long id);

    List<Post> getAllPosts();

    List<Post> getAllPostsByNickname(String nickname);
}
