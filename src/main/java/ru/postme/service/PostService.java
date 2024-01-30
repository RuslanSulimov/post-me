package ru.postme.service;

import org.springframework.stereotype.Service;
import ru.postme.database.dao.impl.PostDaoImpl;
import ru.postme.database.model.Post;
import java.util.List;

@Service
public class PostService {
    private final PostDaoImpl postDao;

    public PostService (PostDaoImpl postDao) {this.postDao = postDao;}

    public Long createPost(Post post) {
        return postDao.createPost(post);
    }

    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    public Post getPostById(Long id) {
        return postDao.getPostById(id);
    }

    public void deletePost(Long id) {
        postDao.deletePost(id);
    }

    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }

    public List<Post> getAllPostsByNickname(String nickname) {
        return postDao.getAllPostsByNickname(nickname);
    }
}
