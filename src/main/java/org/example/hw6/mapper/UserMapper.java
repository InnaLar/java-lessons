package org.example.hw6.mapper;

import org.example.hw6.model.User;

public class UserMapper {
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
}
