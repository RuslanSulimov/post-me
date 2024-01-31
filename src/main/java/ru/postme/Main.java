package ru.postme;

import ru.postme.database.dao.impl.UserDaoImpl;
import ru.postme.database.model.User;

public class Main {
    public static void main(String[] args) {
        // пример добавления записи в таблицу через Java-класс
        User newUser = new User();
        newUser.setFirstName("nika");
        newUser.setLastName("rodina");
        newUser.setEmail("dad.pavlo@gmail.com");
        newUser.setNickname("dadpavlo");
        newUser.setPassword("1111");
        Long userId = new UserDaoImpl().createUser(newUser);
        System.out.println();
    }
}