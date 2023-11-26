package org.example.hw6.service;

import lombok.RequiredArgsConstructor;
import org.example.hw6.dao.AccountDao;
import org.example.hw6.dao.UserFileDao;
import org.example.hw6.dto.SaveAccountRequest;
import org.example.hw6.dto.UpdateAccountRequest;
import org.example.hw6.exception.ErrorCode;
import org.example.hw6.exception.ServiceException;
import org.example.hw6.mapper.AccountMapper;
import org.example.hw6.model.Account;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AccountService {
    private final AccountDao accountDao;
    private final UserFileDao userFileDao;
    private final AccountMapper accountMapper;

    public Account save(final SaveAccountRequest request) {
        final Account account = accountMapper.toAccount(request);
        long userId = account.getUserId();
        if (userFileDao.findById(userId).isEmpty()) {
            throw new ServiceException(ErrorCode.ERR_CODE_001, userId);
        }
        if (accountDao.findById(account.getId()).isPresent()) {
            throw new ServiceException(ErrorCode.ERR_CODE_004, account.getId());
        }
        return accountDao.save(account);
    }

    public Account update(final Long id, final UpdateAccountRequest request) {
        Optional<Account> account = accountDao.findById(id);
        if (account.isEmpty()) {
            throw new ServiceException(ErrorCode.ERR_CODE_003, id);
        }
        accountMapper.updateAccount(request, account.get());
        return accountDao.update(account.get());
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public void deleteById(final Long id) {
        Optional<Account> account = accountDao.findById(id);
        if (account.isEmpty()) {
            throw new ServiceException(ErrorCode.ERR_CODE_003, id);
        }
        accountDao.deleteById(id);
    }

    public Account findById(final Long id) {
        Optional<Account> account = accountDao.findById(id);
        if (account.isEmpty()) {
            throw new ServiceException(ErrorCode.ERR_CODE_003, id);
        }
        return account.get();
    }

    public List<Account> findByUserId(final Long id) {
        return accountDao.findByUserId(id);
    }
}
