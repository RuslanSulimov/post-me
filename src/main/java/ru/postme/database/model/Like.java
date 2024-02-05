package ru.postme.database.model;

import jakarta.persistence.*;

@Entity
@Table (name = "LIKE")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn (name = "POST_ID")
    private Post post;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String toString() {
        return "Like id is "+ id + "!";
    }
}
