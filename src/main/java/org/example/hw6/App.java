package org.example.hw6;

import org.example.hw6.dao.UserFileDao;
import org.example.hw6.dto.SaveUserRequest;
import org.example.hw6.dto.UpdateUserRequest;
import org.example.hw6.mapper.UserMapper;
import org.example.hw6.service.UserService;

import java.nio.file.Path;
import java.util.Random;

public class App {
    private static final Random RANDOM = new Random();

    public static void main(final String[] args) {
        final UserService userService = createDependencies();

        for (int i = 0; i < 1000; i++) {
            userService.save(createSaveUserRequest());
        }

        System.out.println(userService.findAll());
    }

    private static UpdateUserRequest createUpdateUserRequest() {
        return UpdateUserRequest.builder()
            .lastName("newLastName")
            .phoneNumber("newPhoneNumber")
            .build();
    }

    private static SaveUserRequest createSaveUserRequest() {
        return SaveUserRequest.builder()
            .phoneNumber("1234567890")
            .password(RANDOM.longs().toString())
            .build();
    }

    private static UserService createDependencies() {
        final UserMapper userMapper = new UserMapper();
        final Path path = Path.of("user.csv");
        final UserFileDao userFileDao = new UserFileDao(userMapper, path);
        return new UserService(userFileDao, userMapper);
    }

}
