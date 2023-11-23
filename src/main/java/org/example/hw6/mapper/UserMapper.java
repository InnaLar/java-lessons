package org.example.hw6.mapper;

import org.example.hw6.dto.SaveUserRequest;
import org.example.hw6.dto.UpdateUserRequest;
import org.example.hw6.model.User;

import java.util.Random;

public class UserMapper {
    private final Random random = new Random();

    public User toUser(final String user) {
        final String[] cols = user.split(";");
        return User.builder()
            .id(Long.parseLong(cols[0]))
            .lastName(cols[1])
            .phoneNumber(cols[2])
            .build();
    }

    public String toCsvRow(final User user) {
        return String.format("%s;%s;%s", user.getId(), user.getLastName(), user.getPhoneNumber());
    }

    public void updateUser(final UpdateUserRequest request, final User user) {
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());
    }

    public User toUser(SaveUserRequest request) {
        return User.builder()
            .id(random.nextLong(1000))
            .phoneNumber(request.getPhoneNumber())
            .password(request.getPassword())
            .build();
    }
}
