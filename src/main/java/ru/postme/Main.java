package ru.postme;

import ru.postme.database.dao.impl.CommentDaoImpl;
import ru.postme.database.dao.impl.LikeDaoImpl;
import ru.postme.database.dao.impl.PostDaoImpl;
import ru.postme.database.dao.impl.UserDaoImpl;
import ru.postme.database.model.Comment;
import ru.postme.database.model.Like;
import ru.postme.database.model.Post;
import ru.postme.database.model.User;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {



       // пример нахождения всех постов пользователя
//        Scanner input3 = new Scanner(System.in);
//        System.out.print("Enter nickname of user whose posts you want to find: ");
//        String nickname = input3.nextLine();
//
//        List<Post> allUserPost = new PostDaoImpl().getAllPostsByNickname(nickname);
//
//        System.out.println("Current user has these posts: \n");
//        for (Post post: allUserPost) {
//            System.out.println(post);
//        }



        // пример нахождения всех лайков пользователя
//        Scanner input3 = new Scanner(System.in);
//        System.out.print("Enter nickname of user whose likes you want to find: ");
//        String nickname = input3.nextLine();
//
//        List<Like> allUserLikes = new LikeDaoImpl().getAllUserLikes(nickname);
//
//        System.out.println("Current user has these likes: \n");
//        for (Like like: allUserLikes) {
//            System.out.println(like);
//        }



        // пример нахождения всех комментариев пользователя
//        Scanner input3 = new Scanner(System.in);
//        System.out.print("Enter nickname of user whose comments you want to find: ");
//        String nickname = input3.nextLine();
//
//        List<Comment> allUserComments = new CommentDaoImpl().getAllUserComments(nickname);
//
//        System.out.println("Current user has these comments: \n");
//        for (Comment comment: allUserComments) {
//            System.out.println(comment);
//        }



        // пример нахождения всех комментариев поста
//        Scanner input3 = new Scanner(System.in);
//        System.out.print("Enter id of post whose comments you want to find: ");
//        Long postId = input3.nextLong();
//
//        List<Comment> allPostComments = new CommentDaoImpl().getAllPostComments(postId);
//
//        System.out.println("Current post has these comments: \n");
//        for (Comment comment: allPostComments) {
//            System.out.println(comment);
//        }



        // пример нахождения всех лайков поста
//        Scanner input3 = new Scanner(System.in);
//        System.out.print("Enter id of post whose likes you want to find: ");
//        Long postId = input3.nextLong();
//
//        List<Like> allPostLikes = new LikeDaoImpl().getAllPostLikes(postId);
//
//        System.out.println("Current post has these likes: \n");
//        for (Like like: allPostLikes) {
//            System.out.println(like);
//        }


        //пример создания лайка
//        Scanner input4 = new Scanner(System.in);
//        System.out.print("Enter id of post that you want to like: ");
//        Long id = input4.nextLong();
//
//        Post postFoundById = new PostDaoImpl().getPostById(id);
//        Like newUserLike = new Like();
//        newUserLike.setPost(postFoundById);
//        newUserLike.setUser(postFoundById.getUser());
//
//        Long likeId = new LikeDaoImpl().createLike(newUserLike);
//        System.out.println("You liked post №" + postFoundById.getId() + "!");



        //пример нахождения лайка по id
//        Scanner input5 = new Scanner(System.in);
//        System.out.print("Enter id of like that you want to find: ");
//        Long likeId = input5.nextLong();
//
//        Like likeFoundById = new LikeDaoImpl().getLikeById(likeId);
//        System.out.println("Found like info: " + "\n" + likeFoundById);



        //пример удаления лайка
//        Scanner input2 = new Scanner(System.in);
//        System.out.print("Enter id of like that you want to delete: ");
//        Long likeDeleteId = input2.nextLong();
//
//        Like likeDeleteById = new LikeDaoImpl().getLikeById(likeDeleteId);
//        System.out.println("This like was deleted: " + "\n" + likeDeleteById);
//        new LikeDaoImpl().deleteLike(likeDeleteId);

//      //пример нахождения всех лайков
//        List<Like> allLikes = new LikeDaoImpl().getAllLikes();
//        for (Like like: allLikes) {
//            System.out.println(like);
//        }



        //пример создания комментария
//        Scanner input4 = new Scanner(System.in);
//        System.out.print("Enter id of post that you want to comment: ");
//        Long id = input4.nextLong();
//
//        Post postFoundById = new PostDaoImpl().getPostById(id);
//
//        Comment newUserComment = new Comment();
//        newUserComment.setUser(postFoundById.getUser());
//        newUserComment.setPost(postFoundById);
//        newUserComment.setContent("*Comment*");
//        Date currentDate = new Date();
//        newUserComment.setDate(currentDate);
//        Long commentId = new CommentDaoImpl().createComment(newUserComment);
//        System.out.println();



        //пример нахождения комментария по id
//        Scanner input5 = new Scanner(System.in);
//        System.out.print("Enter id of comment that you want to find: ");
//        Long commentId = input5.nextLong();
//
//        Comment commentFoundById = new CommentDaoImpl().getCommentById(commentId);
//        System.out.println("Found comment info: " + "\n" + commentFoundById);



        //пример изменения даннх комментария
//        Scanner input1 = new Scanner(System.in);
//        System.out.print("Enter id of comment that you want to edit: ");
//        Long commentEditId = input1.nextLong();
//
//        Comment commentEditById = new CommentDaoImpl().getCommentById(commentEditId);
//        System.out.println("Previous comment info: " + "\n" + commentEditById);
//
//        commentEditById.setContent("*Changed comment content*");
//
//        new CommentDaoImpl().updateComment(commentEditById);
//        System.out.println("Updated comment info: " +"\n"+ commentEditById);



        //пример удаления комментария
//        Scanner input2 = new Scanner(System.in);
//        System.out.print("Enter id of comment that you want to delete: ");
//        Long commentDeleteId = input2.nextLong();
//
//        Comment commentDeleteById = new CommentDaoImpl().getCommentById(commentDeleteId);
//        System.out.println("This comment was deleted: " + "\n" + commentDeleteById);
//        new CommentDaoImpl().deleteComment(commentDeleteId);
//
//      //пример нахождения всех комментов
//        List<Comment> allComments = new CommentDaoImpl().getAllComments();
//        for (Comment comment: allComments) {
//            System.out.println(comment);
//        }




        //пример создания поста
//        Scanner input4 = new Scanner(System.in);
//        System.out.print("Enter id of user that you want to find: ");
//        Long id = input4.nextLong();
//
//        User userFoundById = new UserDaoImpl().getUserById(id);
//
//        Post newUserPost = new Post();
//        newUserPost.setUser(userFoundById);
//        newUserPost.setContent("*Whatever user wants to post*");
//        Date currentDAte = new Date();
//        newUserPost.setDate(currentDAte);
//        Long postId = new PostDaoImpl().createPost(newUserPost);
//        System.out.println();



        //пример нахождения поста по id
//        Scanner input5 = new Scanner(System.in);
//        System.out.print("Enter id of post that you want to find: ");
//        Long postId = input5.nextLong();
//
//        Post postFoundById = new PostDaoImpl().getPostById(postId);
//        System.out.println("Found post info: " + "\n" + postFoundById);



        //пример изменения даннх поста
//        Scanner input1 = new Scanner(System.in);
//        System.out.print("Enter id of post that you want to update: ");
//        Long postUpdateId = input1.nextLong();
//
//        Post postUpdateById = new PostDaoImpl().getPostById(postUpdateId);
//        System.out.println("Previous post info: " + "\n" + postUpdateById);
//
//        postUpdateById.setContent("*Changed post content*");
//
//        new PostDaoImpl().updatePost(postUpdateById);
//        System.out.println("Updated post info: " +"\n"+ postUpdateById);


        //пример удаления поста
//        Scanner input2 = new Scanner(System.in);
//        System.out.print("Enter id of post that you want to delete: ");
//        Long postDeleteId = input2.nextLong();
//
//        Post postDeleteById = new PostDaoImpl().getPostById(postDeleteId);
//        System.out.println("This post was deleted: " + "\n" + postDeleteById);
//        new PostDaoImpl().deletePost(postDeleteId);
//
//        пример нахождения всех постов
//        List<Post> allPosts = new PostDaoImpl().getAllPosts();
//        for (Post post: allPosts) {
//            System.out.println(post);
//        }


        // пример добавления записи в таблицу через Java-класс
//            User newUser = new User();
//            newUser.setFirstName("nika");
//            newUser.setLastName("rodina");
//            newUser.setEmail("dad.pavlo@gmail.com");
//            newUser.setNickname("dadpavlo");
//            newUser.setPassword("1111");
//            Long userId = new UserDaoImpl().createUser(newUser);
//            System.out.println();
//
//
//
////         пример нахождения пользователя по Id
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter id of user that you want to find: ");
//        Long id = input.nextLong();
//
//        User userFoundById = new UserDaoImpl().getUserById(id);
//        System.out.println("Found user info: " + userFoundById);
//
//
//
////         пример изменения данных пользователя
//        Scanner input1 = new Scanner(System.in);
//        System.out.print("Enter id of user that you want to update: ");
//        Long userUpdateId = input1.nextLong();
//
//        User userUpdateById = new UserDaoImpl().getUserById(userUpdateId);
//        System.out.println("Previous user info: " + userUpdateById);
//
//        userUpdateById.setFirstName("ruslan");
//        userUpdateById.setLastName("sulimov");
//        userUpdateById.setEmail("rusano@gmail.com");
//        userUpdateById.setNickname("rusano");
//        userUpdateById.setPassword("2222");
//
//        new UserDaoImpl().updateUser(userUpdateById);
//        System.out.println("Updated user info: " + userUpdateById);
//
//
//
            //пример удаления пользователя
//        Scanner input2 = new Scanner(System.in);
//        System.out.print("Enter id of user that you want to delete: ");
//        Long userDeleteId = input2.nextLong();
//
//        User userDeleteById = new UserDaoImpl().getUserById(userDeleteId);
//        System.out.println("This user was deleted: " + userDeleteById);
//        new UserDaoImpl().deleteUser(userDeleteId);
//
//
//
//         пример нахождения пользователя по никнейму
//        Scanner input3 = new Scanner(System.in);
//        System.out.print("Enter nickname of user that you want to find: ");
//        String nickname = input3.nextLine();
//
//        User userByNickname = new UserDaoImpl().getUserByNickname(nickname);
//        System.out.println("Found user: " + userByNickname);
//
//
//
////         пример нахождения всех пользователей
//        List<User> allUsers = new UserDaoImpl().getAllUsers();
//        for (User user: allUsers) {
//            System.out.println(user);
//        }
    }
}