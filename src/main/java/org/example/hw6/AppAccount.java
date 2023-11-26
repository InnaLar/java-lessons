package org.example.hw6;

import org.example.hw6.dao.AccountDao;
import org.example.hw6.dao.UserFileDao;
import org.example.hw6.dto.SaveAccountRequest;
import org.example.hw6.dto.UpdateAccountRequest;
import org.example.hw6.mapper.AccountMapper;
import org.example.hw6.mapper.UserMapper;
import org.example.hw6.service.AccountService;

import java.nio.file.Path;

public class AppAccount {
    public static void main(final String[] args) {
        AccountService accountService = createDependencies();
        accountService.save(SaveAccountRequest
            .builder()
            .number("11112222")
            .userId(2L)
            .build());
        //accountService.deleteById(2L);
        accountService.update(1L, UpdateAccountRequest
            .builder()
            .userId(4L)
            .build());
        accountService.findAll().forEach(System.out::println);
        System.out.println(accountService.findById(1L));

        accountService.findByUserId(2L).forEach(System.out::println);
    }

    public static AccountService createDependencies() {
        AccountMapper accountMapper = new AccountMapper();
        Path pathAccount = Path.of("account.csv");
        AccountDao accountDao = new AccountDao(accountMapper, pathAccount);
        UserMapper userMapper = new UserMapper();
        Path pathUser = Path.of("user.csv");
        UserFileDao userFileDao = new UserFileDao(userMapper, pathUser);

        return new AccountService(accountDao, userFileDao, accountMapper);
     }

}
