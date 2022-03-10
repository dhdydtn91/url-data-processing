package com.api.urldataprocessing.presentation;

import com.api.urldataprocessing.common.exception.InvalidValueException;
import com.api.urldataprocessing.common.response.ErrorCode;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class UrlDataProcessValidator {


    public void validate(RequestDataDto dto) {
        if (!StringUtils.hasText(dto.getUrl())) {
            throw new InvalidValueException("Url은 ", ErrorCode.INVALID_INPUT_VALUE);
        }

        if (!StringUtils.hasText(dto.getExposureType())) {
            throw new InvalidValueException("ExposureType은 ", ErrorCode.INVALID_INPUT_VALUE);
        }

        if (!"HTML 태그 제외".equals(dto.getExposureType()) && !"TEXT 전체".equals(dto.getExposureType())) {
            throw new InvalidValueException("ExposureType은 ", ErrorCode.INVALID_INPUT_VALUE);
        }
    }
}
