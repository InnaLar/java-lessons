package org.example.hw6.service;

import lombok.RequiredArgsConstructor;
import org.example.hw6.dao.AccountDao;
import org.example.hw6.dao.UserFileDao;
import org.example.hw6.dto.SaveUserRequest;
import org.example.hw6.dto.UpdateUserRequest;
import org.example.hw6.exception.ErrorCode;
import org.example.hw6.exception.ServiceException;
import org.example.hw6.mapper.UserMapper;
import org.example.hw6.model.Account;
import org.example.hw6.model.User;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserService {
    private final UserFileDao userFileDao;
    private final AccountDao accountDao;
    private final UserMapper userMapper;

    public User save(final SaveUserRequest request) {
        final User user = userMapper.toUser(request);
        if (userFileDao.findById(user.getId()).isPresent()) {
            throw new ServiceException(ErrorCode.ERR_CODE_002, user.getId());
        }
        return userFileDao.save(user);
    }

    public User update(final Long id, final UpdateUserRequest request) {
        Optional<User> user = userFileDao.findById(id);
        /*.orElseThrow();*/
        if (user.isEmpty()) {
           throw new ServiceException(ErrorCode.ERR_CODE_001, id);
        }
        userMapper.updateUser(request, user.get());
        return userFileDao.update(user.get());
    }

    public List<User> findAll() {
        return userFileDao.findAll();
    }

    public User findById(final Long id) {
        Optional<User> user = userFileDao.findById(id);
        if (user.isEmpty()) {
            throw new ServiceException(ErrorCode.ERR_CODE_001, id);
        }
        return user.get();
    }

    public void deleteById(final Long id) {
        List<Account> accounts = accountDao.findByUserId(id);
        if (!accounts.isEmpty()) {
           throw new ServiceException(ErrorCode.ERR_CODE_005, id);
        }
        userFileDao.deleteById(id);
    }

}
