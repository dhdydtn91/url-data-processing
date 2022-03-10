package com.api.urldataprocessing.common.exception;

import com.api.urldataprocessing.common.response.ErrorCode;
import lombok.Getter;

@Getter
public class ScrapingFailException extends BusinessException {

    public ScrapingFailException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ScrapingFailException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
