package ru.postme.service;

import org.springframework.stereotype.Service;
import ru.postme.database.dao.impl.LikeDaoImpl;
import ru.postme.database.model.Like;

import java.util.List;
@Service
public class LikeService {

    private final LikeDaoImpl likeDao;

    public LikeService (LikeDaoImpl likeDao) {this.likeDao = likeDao;}

    public Long createLike(Like like) { return likeDao.createLike(like); }

    public Like getLikeById(Long id) { return  likeDao.getLikeById(id); }

    public void deleteLike(Long id) { likeDao.deleteLike(id); }

    public List<Like> getAllLikes() { return likeDao.getAllLikes(); }

    public List<Like> getAllUserLikes(String nickname) { return likeDao.getAllUserLikes(nickname); }

    public List<Like> getAllPostLikes(Long postId) { return likeDao.getAllPostLikes(postId); }


}
