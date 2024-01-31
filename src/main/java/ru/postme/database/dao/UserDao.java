package ru.postme.database.dao;

import ru.postme.database.model.User;

public interface UserDao {
    Long createUser(User user);
    void updateUser(User user);
    User getUserById(Long id);
    void  deleteUser(Long id);
}
