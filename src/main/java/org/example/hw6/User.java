package org.example.hw6;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private int id;
    private String lastName;
    private String phoneNumber;
}
