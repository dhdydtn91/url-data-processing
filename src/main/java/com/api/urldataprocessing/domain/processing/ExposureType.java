package com.api.urldataprocessing.domain.processing;

import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.common.exception.InvalidValueException;
import com.api.urldataprocessing.common.response.ErrorCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.function.Function;

@Getter
public enum ExposureType {
    HTML_TAG_EXCLUDE("HTML 태그 제외", HtmlTagExcludeData::of),
    TEXT_ALL("TEXT 전체", TextAllData::of);

    private final String type;
    private final Function<String, ScrapingData> scrapingData;

    ExposureType(String type, Function<String, ScrapingData> scrapingData) {
        this.type = type;
        this.scrapingData = scrapingData;
    }

    public static ExposureType getType(String exposureType) {
        return Arrays.stream(values())
                .filter(type -> isSame(type.getType(), exposureType))
                .findAny()
                .orElseThrow(() -> new InvalidValueException("ExposureType의 값 " + exposureType + "은", ErrorCode.INVALID_INPUT_VALUE));
    }

    public static ScrapingData getTypeData(ScrapingDto dto) {
        ExposureType type = getType(dto.getExposureType());
        return type.getScrapingData().apply(dto.getHtml());
    }

    public String getType() {
        return type;
    }

    public static boolean isSame(String type, String exposureType) {
        return type.equals(exposureType);
    }
}
