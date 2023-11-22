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
    public Optional<Account> findById(final String id) {
        return Optional.empty();
    }

    @Override
    public Account save(final Account user) {
        return null;
    }

    @Override
    public void deleteById(final String id) {

    }

    @Override
    public Account update(final Account user) {
        return null;
    }
}
