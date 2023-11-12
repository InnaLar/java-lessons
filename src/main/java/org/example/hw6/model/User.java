package org.example.hw6.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private Long id;
    private String lastName;
    private String phoneNumber;
}
