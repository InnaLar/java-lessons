package org.example.hw6.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    ERR_CODE_001("ERR.CODE.001", "User with id %s not found"),
    ERR_CODE_002("ERR.CODE.002", "User with id %s already exists"),
    ERR_CODE_003("ERR.CODE.003", "Account with id %s not found"),
    ERR_CODE_004("ERR.CODE.004", "Account with id %s already exists"),
    ERR_CODE_005("ERR.CODE.005", "User with id %s has related accounts");

    private final String code;
    private final String description;

    public String formatDescription(final Object... args) {
        return String.format(description, args);
    }
}
