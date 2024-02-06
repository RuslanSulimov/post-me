package ru.postme.database.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "CONTENT")

    private String content;
    @Column(name = "CREATE_DATE")

    private Date date;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @OneToMany(mappedBy = "post")

    private List<Comment> comments;
    @OneToMany(mappedBy = "post")

    private List<Like> likes;

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return id + "\n" + user.getNickname() + "\n" + date + "\n" + content;
    }
}
