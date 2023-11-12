package org.example.hw6.dao;

import org.example.hw6.model.Account;

import java.util.List;
import java.util.Optional;

public class AccountDao implements CrudRepository<Account, String> {
    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Account save(Account user) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Account update(Account user) {
        return null;
    }
}
