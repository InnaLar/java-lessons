package org.example.jdbc.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    ERR_CODE_001("ERR.CODE.001", "File with id %s not found"),
    ERR_CODE_002("ERR.CODE.002", "Extension %s not found in table extension_refl");

    private final String code;
    private final String description;

    public String formatDescription(final Object... args) {
        return String.format(description, args);
    }
}
