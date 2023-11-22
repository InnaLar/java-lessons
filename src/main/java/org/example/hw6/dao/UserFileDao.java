package org.example.hw6.dao;

import lombok.RequiredArgsConstructor;
import org.example.hw6.mapper.UserMapper;
import org.example.hw6.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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
            Files.writeString(path, userMapper.toCsvRow(user) + System.lineSeparator(),
                StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            return user;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void deleteById(final Long id) {
        //throw new IllegalStateException("implement me");
        ArrayList<User> users = new ArrayList<>(findAll());
        users.removeIf(user -> user.getId().equals(id));
        update(users);
    }

    @Override
    public User update(final User user) {
        ArrayList<User> users = new ArrayList<>(findAll());
        Optional<User> userToReplace = findById(user.getId());

        if (userToReplace.isPresent()) {
            int i = 0;
            for (User userInList : users
            ) {
                if (userInList.equals(userToReplace.get())) {
                    break;
                } else {
                    i++;
                }
            }
            if (users.size() < i) {
                i = -1;
            }
            if (i != -1) {
                users.set(i, user);
                update(users);
                return user;
            }
        }
        throw new IllegalArgumentException("updateError");

        /*if (userToReplace.isPresent()) {
            User foundUser = userToReplace.get();
            int id = users.indexOf(foundUser);
            users.set(id, user);
            update();
            return user;
        }*/

    }

    public void update(final List<User> users) {
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            Files.writeString(path, "id; secondName; phoneNumber; " + System.lineSeparator(),
                StandardOpenOption.WRITE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*findAll()*/
        users.forEach(user -> {
            try {
                Files.writeString(path, userMapper.toCsvRow(user) + System.lineSeparator(),
                    StandardOpenOption.WRITE, StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
