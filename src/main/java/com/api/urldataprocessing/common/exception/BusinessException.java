package com.api.urldataprocessing.common.exception;

import com.api.urldataprocessing.common.response.ErrorCode;
import lombok.Getter;

/**
 * BusinessException 또는 BusinessException 을 확장한 Exception 은
 * 서비스 운영에서 비지니스 로직에서 예외가 발생한 Exception 을 표현한다.
 * <p>
 * 그렇기 때문에 http status: 200 이면서 result: FAIL 을 표현하고
 * 특정 ErrorCode 만 alert 를 포함한 모니터링 대상으로 한다.
 */
@Getter
public class BusinessException extends RuntimeException {
    private ErrorCode errorCode;

    public BusinessException() {
    }

    public BusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(String message, ErrorCode errorCode) {
        super(message + errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
