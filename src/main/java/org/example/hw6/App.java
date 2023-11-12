package org.example.hw6;

import org.example.hw6.dao.UserFileDao;
import org.example.hw6.mapper.UserMapper;
import org.example.hw6.model.User;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class App {

    public static void main(final String[] args) {
        UserMapper userMapper = new UserMapper();
        UserFileDao userFileDao = new UserFileDao(userMapper, Path.of("user.csv"));

        List<User> users = userFileDao.findAll();
        users.forEach(u -> System.out.println(u.getLastName()));

        Optional<User> optionalUser = userFileDao.findById(1L);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println(user.getLastName());
        }

        User dozorova = User.builder()
            .id(4L)
            .lastName("Dozorova")
            .phoneNumber("2272519")
            .build();

        userFileDao.save(dozorova);
    }

}
