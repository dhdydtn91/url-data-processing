package com.api.urldataprocessing.common.exception;

import com.api.urldataprocessing.common.response.ErrorCode;
import lombok.Getter;

@Getter
public class InvalidValueException extends BusinessException {

    public InvalidValueException() {
    }

    public InvalidValueException(ErrorCode errorCode) {
        super(errorCode);
    }

    public InvalidValueException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
