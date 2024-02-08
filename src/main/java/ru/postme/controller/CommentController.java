package ru.postme.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.postme.database.dao.impl.PostDaoImpl;
import ru.postme.database.dao.impl.UserDaoImpl;
import ru.postme.database.model.Comment;
import ru.postme.database.model.User;
import ru.postme.database.model.Post;
import ru.postme.service.CommentService;
import java.util.Date;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController (CommentService commentService) {this.commentService = commentService;}

    @PostMapping("/createComment")
    public ResponseEntity<?> createComment(@RequestParam ("userId") Long userId,
                                           @RequestParam ("postId") Long postId,
                                           @RequestParam ("content") String content) {

        Comment comment = new Comment();
        User user = new UserDaoImpl().getUserById(userId);
        Post post = new PostDaoImpl().getPostById(postId);
        Date date = new Date();

        comment.setUser(user);
        comment.setPost(post);
        comment.setContent(content);
        comment.setDate(date);

        return ResponseEntity.ok(commentService.createComment(comment));
    }

    @PatchMapping("/updateComment/{id}")
    public ResponseEntity<?> updateComment(@PathVariable ("id") Long id,
                                           @RequestParam ("content") String content) {

        Comment comment = commentService.getCommentById(id);
        comment.setContent(content);
        commentService.updateComment(comment);

        return null;
    }

    @GetMapping("/getCommentById/{id}")
    public ResponseEntity<?> getCommentById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok(commentService.getCommentById(id));
    }

    @DeleteMapping("/deleteComment/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable ("id") Long id) {
        commentService.deleteComment(id);
        return  null;
    }
    @GetMapping("/getAllComments")
    public ResponseEntity<?> getAllComments() { return ResponseEntity.ok(commentService.getAllComments());}

    @GetMapping("/getAllUserComments/{nickname}")
    public ResponseEntity<?> getAllUserComments(@PathVariable ("nickname") String nickname) {
        return ResponseEntity.ok(commentService.getAllUserComments(nickname));
    }

    @GetMapping ("/getAllPostComments/{postId}")
    public ResponseEntity<?> getAllPostComments(@PathVariable ("postId") Long postId) {
        return  ResponseEntity.ok(commentService.getAllPostComments(postId));
    }
}
