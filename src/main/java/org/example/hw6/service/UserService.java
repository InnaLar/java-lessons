package org.example.hw6.service;

import lombok.RequiredArgsConstructor;
import org.example.hw6.dao.UserFileDao;
import org.example.hw6.dto.SaveUserRequest;
import org.example.hw6.dto.UpdateUserRequest;
import org.example.hw6.exception.ErrorCode;
import org.example.hw6.exception.ServiceException;
import org.example.hw6.mapper.UserMapper;
import org.example.hw6.model.User;

import java.util.List;

@RequiredArgsConstructor
public class UserService {
    private final UserFileDao userFileDao;
    private final UserMapper userMapper;

    public User save(final SaveUserRequest request) {
        final User user = userMapper.toUser(request);
        if (userFileDao.findById(user.getId()).isPresent()) {
            throw new ServiceException(ErrorCode.ERR_CODE_002, user.getId());
        }
        return userFileDao.save(user);
    }

    public User update(final Long id, final UpdateUserRequest request) {
        User user = userFileDao.findById(id)
            .orElseThrow();
        userMapper.updateUser(request, user);
        return userFileDao.update(user);
    }

    public List<User> findAll() {
        return userFileDao.findAll();
    }

}
