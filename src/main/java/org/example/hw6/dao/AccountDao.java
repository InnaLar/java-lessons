package org.example.hw6.dao;

import lombok.RequiredArgsConstructor;
import org.example.hw6.mapper.AccountMapper;
import org.example.hw6.model.Account;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class AccountDao implements CrudRepository<Account, Long> {

    private final AccountMapper accountMapper;
    private final Path path;

    @Override
    public List<Account> findAll() {
        try (Stream<String> streamString = Files.lines(path)) {
            return streamString
                .skip(1)
                .map(accountMapper::toAccount)
                .toList();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Optional<Account> findById(final Long id) {
        return findAll()
            .stream()
            .filter(account -> account.getId().equals(id))
            .findFirst();
    }

    @Override
    public Account save(final Account account) {
        try {
           Files.writeString(path, accountMapper.toCsvRow(account) + System.lineSeparator(),
               StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
           return account;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void deleteById(final Long id) {
        ArrayList<Account> accounts = new ArrayList<>(findAll());
        accounts.removeIf(account -> account.getId().equals(id));
        update(accounts);
    }

    @Override
    public Account update(final Account account) {
        ArrayList<Account> accounts = new ArrayList<>(findAll());
        accounts.replaceAll(account1 -> {
            if (account1.getUserId().equals(account.getId())) {
                return account;
            }
            return account1;
        });
        update(accounts);
        return account;
    }

    private void update(final List<Account> accounts) {
        try {
            Files.writeString(path, "id; number; idUser" + System.lineSeparator(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
            for (Account account:accounts
                 ) {
                Files.writeString(path, accountMapper.toCsvRow(account) + System.lineSeparator(), StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Account> findByUserId(final Long id) {
        return findAll()
            .stream()
            .filter(account -> account.getUserId().equals(id))
            .toList();
    }
}
