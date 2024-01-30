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

    public Long createUser(User user) {
        return userDao.createUser(user);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    public User getUserByNickname(String nickname) {
        return userDao.getUserByNickname(nickname);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
