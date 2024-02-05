package ru.postme.database.dao;

import ru.postme.database.model.User;

import java.util.List;

public interface UserDao {
    Long createUser(User user);
    void updateUser(User user);
    User getUserById(Long id);
    void deleteUser(Long id);
    User getUserByNickname(String nickname);
    List<User> getAllUsers();
}
