package ru.postme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.postme.database.dao.impl.UserDaoImpl;
import ru.postme.database.model.Post;
import ru.postme.database.model.User;
import ru.postme.service.PostService;


import java.util.Date;



@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController (PostService postService) {this.postService = postService;}

    @PostMapping ("/createPost")
    public ResponseEntity<?> createPost (
            @RequestParam ("userId") Long userId,
            @RequestParam ("content") String content,
            @RequestBody Post post) {

        Date date = new Date();

        User user = new UserDaoImpl().getUserById(userId);

        post.setUser(user);
        post.setDate(date);
        post.setContent(content);

        return ResponseEntity.ok(postService.createPost(post));
    }
    @PatchMapping ("/updatePost/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable ("postId") Long id,
                                        @RequestParam ("content") String content,
                                        @RequestBody Post post) {

        post = postService.getPostById(id);
        post.setContent(content);
        postService.updatePost(post);
        return null;
    }

    @GetMapping ("/getPostById/{postId}")
    public ResponseEntity<?> getPostById(@PathVariable ("postId") Long id) { return ResponseEntity.ok(postService.getPostById(id));}

    @DeleteMapping ("/deletePost/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable ("postId") Long id) {
        postService.deletePost(id);
        return null;
    }

    @GetMapping("/getAllPosts")
    public ResponseEntity<?> getAllPosts() { return ResponseEntity.ok(postService.getAllPosts()); }

    @GetMapping("/getAllPostsByNickname/{nickname}")
    public ResponseEntity<?> getAllPostsByNickname(@PathVariable ("nickname") String nickname) {
        return ResponseEntity.ok(postService.getAllPostsByNickname(nickname));
    }
}
