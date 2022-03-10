package com.api.urldataprocessing.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // Common
    INVALID_INPUT_VALUE(400, "유효하지 않는 입력값 입니다."),
    METHOD_NOT_ALLOWED(405, "지원하지 않는 Method 입니다."),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    FAILED_HTML_SCRAPING(200, "url 주소에 대한 HTML 스크래핑이 실패하였습니다.");

    private final String message;
    private int status;

    ErrorCode(final int status, final String message) {
        this.status = status;
        this.message = message;
    }
}