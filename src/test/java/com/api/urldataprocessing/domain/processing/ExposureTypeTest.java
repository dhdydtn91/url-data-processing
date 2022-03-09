package com.api.urldataprocessing.domain.processing;

import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExposureTypeTest {

    @DisplayName("type이 HTML 태그 제외일때 HTML_TAG_EXCLUDE가 리턴된다.")
    @Test
    void getType_HTML_TAG_EXCLUDE() {
        String type = "HTML 태그 제외";
        ExposureType exposureType = ExposureType.getType(type);

        assertThat(exposureType).isEqualTo(ExposureType.HTML_TAG_EXCLUDE);
    }

    @DisplayName("type이 TEXT 전체일때 TEXT_ALL 리턴된다.")
    @Test
    void getType_TEXT_ALL() {
        String type = "TEXT 전체";
        ExposureType exposureType = ExposureType.getType(type);

        assertThat(exposureType).isEqualTo(ExposureType.TEXT_ALL);
    }

    @DisplayName("type이 TEXT 전체일때 TEXT_ALL 리턴된다.")
    @Test
    void getTypeData_HTML_TAG_EXCLUDE() {
        int statusCode = 200;
        String html = "<HTML>AaBbCD01234</HTML>";
        String message = "success";
        ScrapingDto scrapingDto = getScrapingDto(statusCode, html, message, "HTML 태그 제외");

        String data = ExposureType.getTypeData(scrapingDto);

        assertThat(data).isEqualTo("AaBbCD01234");
    }

    @DisplayName("type이 TEXT 전체일때 TEXT_ALL 리턴된다.")
    @Test
    void getTypeData_TEXT_ALL() {
        int statusCode = 200;
        String html = "<HTML>AaBbCD01234</HTML>";
        String message = "success";
        ScrapingDto scrapingDto = getScrapingDto(statusCode, html, message, "TEXT 전체");

        String data = ExposureType.getTypeData(scrapingDto);

        assertThat(data).isEqualTo("<HTML>AaBbCD01234</HTML>");
    }

    @DisplayName("올바르지 않은 type이 들어왔을 시 예외발생")
    @Test
    void getTypeData_Exception() {
        String type = "CSS 태그 제외";

        assertThatThrownBy(() -> {
            ExposureType.getType(type);
        }).isInstanceOf(RuntimeException.class);
    }

    private ScrapingDto getScrapingDto(int statusCode, String html, String message, String exposureType) {
        ScrapingDto dto = ScrapingDto.builder()
                .statusCode(statusCode)
                .html(html)
                .message(message)
                .exposureType(exposureType)
                .outputUnit(4)
                .build();
        return dto;
    }
}