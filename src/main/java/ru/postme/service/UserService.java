package ru.postme.service;

import org.springframework.stereotype.Service;
import ru.postme.database.dao.impl.UserDaoImpl;
import ru.postme.database.model.User;

import java.util.List;

@Service
public class UserService {
    private final UserDaoImpl userDao;

    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
