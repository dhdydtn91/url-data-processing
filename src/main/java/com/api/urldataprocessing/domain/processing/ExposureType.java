package com.api.urldataprocessing.domain.processing;

import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;

import java.util.Arrays;

public enum ExposureType {
    HTML_TAG_EXCLUDE("HTML 태그 제외"), TEXT_ALL("TEXT 전체");

    private final String type;

    ExposureType(String type) {
        this.type = type;
    }

    public static ExposureType getType(String exposureType) {
        return Arrays.stream(values())
                .filter(type -> isSame(type.getType(), exposureType))
                .findAny()
                .orElseThrow(() -> new RuntimeException(exposureType + "의 노출유형은 없습니다."));
    }

    public static String getTypeData(ScrapingDto dto) {
        ExposureType type = getType(dto.getExposureType());
        String html = dto.getHtml();
        if (type == HTML_TAG_EXCLUDE) {
            html = html.replaceAll("<[^>]*>", "");
            return html;
        }
        return html;
    }

    public String getType() {
        return type;
    }

    public static boolean isSame(String type, String exposureType) {
        return type.equals(exposureType);
    }
}
