package org.example.hw6.dao;

import lombok.RequiredArgsConstructor;
import org.example.hw6.mapper.UserMapper;
import org.example.hw6.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class UserFileDao implements CrudRepository<User, Long> {

    private final UserMapper userMapper;
    private final Path path;

    @Override
    public List<User> findAll() {
        try (Stream<String> stringStream = Files.lines(path)) {
            return stringStream
                .skip(1)
                .map(userMapper::toUser)
                .toList();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Optional<User> findById(final Long id) {
        return findAll().stream()
            .filter(user -> user.getId().equals(id))
            .findFirst();
    }

    /**
     * Adds a user to the file by writing their information in CSV format.
     *
     * @param user the user to be added
     */
    @Override
    public User save(final User user) {
        try {
            Files.writeString(path, userMapper.toCsvRow(user),
                StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            return user;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        // todo: implement
        throw new IllegalStateException("implement me");
    }

    @Override
    public User update(User user) {
        // todo: implement
        throw new IllegalStateException("implement me");
    }
}
