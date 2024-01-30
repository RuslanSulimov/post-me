package ru.postme.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.postme.database.dao.impl.PostDaoImpl;
import ru.postme.database.dao.impl.UserDaoImpl;
import ru.postme.database.model.Like;
import ru.postme.database.model.Post;
import ru.postme.database.model.User;
import ru.postme.service.LikeService;

@RestController
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping("/createLike")
    public ResponseEntity<?> createLike(@RequestParam("userId") Long userId, @RequestParam("postId") Long postId) {
        User user = new UserDaoImpl().getUserById(userId);
        Post post = new PostDaoImpl().getPostById(postId);
        Like like = new Like();

        like.setUser(user);
        like.setPost(post);

        return ResponseEntity.ok(likeService.createLike(like));
    }

    @GetMapping("/getLikeById/{id}")
    public ResponseEntity<?> getLikeById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(likeService.getLikeById(id));
    }

    @DeleteMapping("/deleteLike/{id}")
    public ResponseEntity<?> deleteLike(@PathVariable("id") Long id) {
        likeService.deleteLike(id);
        return null;
    }

    @GetMapping("/getAllLikes")
    public ResponseEntity<?> getAllLikes() {
        return ResponseEntity.ok(likeService.getAllLikes());
    }

    @GetMapping("/getAllUserLikes/{nickname}")
    public ResponseEntity<?> getAllUserLikes(@PathVariable("nickname") String nickname) {
        return ResponseEntity.ok(likeService.getAllUserLikes(nickname));
    }

    @GetMapping("/getAllPostLikes/{id}")
    public ResponseEntity<?> getAllPostLikes(@PathVariable("id") Long id) {
        return ResponseEntity.ok(likeService.getAllPostLikes(id));
    }

}
