package com.api.urldataprocessing.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    COMMON_INVALID_PARAM("요청값이 잘못되었습니다."),
    SCRAPING_FAILED_HTML_READ("해당 주소의 html을 불러오는데 실패하였습니다.");

    private final String errorMsg;

    public String getErrorMsg(Object... arg) {
        return String.format(errorMsg, arg);
    }
}