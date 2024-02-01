package ru.postme;

import ru.postme.database.dao.UserDao;
import ru.postme.database.dao.impl.UserDaoImpl;
import ru.postme.database.model.User;

import java.util.List;
import java.util.Scanner;


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



//         пример нахождения пользователя по Id
        Scanner input = new Scanner(System.in);
        System.out.print("Enter id of user that you want to find: ");
        Long id = input.nextLong();

        User userFoundById = new UserDaoImpl().getUserById(id);
        System.out.println("Found user info: " + userFoundById);



//         пример изменения данных пользователя
        Scanner input1 = new Scanner(System.in);
        System.out.print("Enter id of user that you want to update: ");
        Long userUpdateId = input1.nextLong();

        User userUpdateById = new UserDaoImpl().getUserById(userUpdateId);
        System.out.println("Previous user info: " + userUpdateById);

        userUpdateById.setFirstName("ruslan");
        userUpdateById.setLastName("sulimov");
        userUpdateById.setEmail("rusano@gmail.com");
        userUpdateById.setNickname("rusano");
        userUpdateById.setPassword("2222");

        new UserDaoImpl().updateUser(userUpdateById);
        System.out.println("Updated user info: " + userUpdateById);



//         пример удаления пользователя
        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter id of user that you want to delete: ");
        Long userDeleteId = input2.nextLong();

        User userDeleteById = new UserDaoImpl().getUserById(userDeleteId);
        System.out.println("This user was deleted: " + userDeleteById);
        new UserDaoImpl().deleteUser(userDeleteId);



//         пример нахождения пользователя/пользователей по никнейму
        Scanner input3 = new Scanner(System.in);
        System.out.print("Enter nickname of user that you want to find: ");
        String nickname = input3.nextLine();

        List<User> userByNickname = new UserDaoImpl().getUserByNickname(nickname);
        System.out.println("Found users: " + userByNickname);



//         пример нахождения всех пользователей
        List<User> allUsers = new UserDaoImpl().getAllUsers();
        for (User user: allUsers) {
            System.out.println(user);
    }
}
}