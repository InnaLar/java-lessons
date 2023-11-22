package org.example.hw6;

import org.example.hw6.dao.UserFileDao;
import org.example.hw6.mapper.UserMapper;
import org.example.hw6.model.User;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class App {
    private static List<User> users;

    public static void main(final String[] args) {
        UserMapper userMapper = new UserMapper();
        UserFileDao userFileDao = new UserFileDao(userMapper, Path.of("user.csv"));

        users = userFileDao.findAll();
        printListUser();

        Optional<User> optionalUser = userFileDao.findById(1L);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println(user.getLastName());
        }

        User dozorova = User.builder()
            .id(5L)
            .lastName("Semenova")
            .phoneNumber("99999999")
            .build();

        userFileDao.save(dozorova);
        users = userFileDao.findAll();
        printListUser();

        userFileDao.deleteById(3L);
        userFileDao.deleteById(4L);

        User larin = User.builder()
            .id(1L)
            .lastName("Larin")
            .phoneNumber("89221741278")
            .build();

        userFileDao.update(larin);
        users = userFileDao.findAll();
        printListUser();
    }

    public static void printListUser() {
        System.out.println("Cписок пользователей");
        users.forEach(u -> System.out.println(u.getLastName()));
        System.out.println("Конец списка пользователей");
    }

}
