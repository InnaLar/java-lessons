package org.example.hw6;

import org.example.hw6.dao.AccountDao;
import org.example.hw6.dao.UserFileDao;
import org.example.hw6.dto.UpdateUserRequest;
import org.example.hw6.mapper.AccountMapper;
import org.example.hw6.mapper.UserMapper;
import org.example.hw6.service.UserService;

import java.nio.file.Path;

public class AppUser {

    public static void main(final String[] args) {
        final UserService userService = createDependencies();

        userService.update(10L, createUpdateUserRequest());
        userService.findAll().forEach(System.out::println);
        userService.deleteById(10L);
    }

    private static UpdateUserRequest createUpdateUserRequest() {
        return UpdateUserRequest.builder()
            .lastName("zorin")
            .phoneNumber("8888888")
            .build();
    }

    private static UserService createDependencies() {
        final UserMapper userMapper = new UserMapper();
        final Path pathUser = Path.of("user.csv");
        final UserFileDao userFileDao = new UserFileDao(userMapper, pathUser);
        final AccountMapper accountMapper = new AccountMapper();
        final Path pathAccount = Path.of("account.csv");
        final AccountDao accountDao = new AccountDao(accountMapper, pathAccount);

        return new UserService(userFileDao, accountDao, userMapper);
    }

}
