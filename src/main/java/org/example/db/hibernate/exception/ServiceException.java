package org.example.db.hibernate.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    private final String code;

    public ServiceException(final ErrorCode errorCode, final Object... args) {
        super(errorCode.formatDescription(args));
        this.code = errorCode.getCode();
    }

}
