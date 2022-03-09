package com.api.urldataprocessing.service;

import com.api.urldataprocessing.appliaction.processing.DataProcessingService;
import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.presentation.ResponseDataDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DataProcessingServiceTest {

    DataProcessingService dataProcessingService;

    @DisplayName("url로 가져온 HTML 데이터를 가공한다.")
    @Test
    void dataProcessing() {
        int statusCode = 200;
        String html = "<HTML>AaBbCD01234</HTML>";
        String message = "success";

        ScrapingDto scrapingDto = getScrapingDto(statusCode, html, message);

        ResponseDataDto responseDataDto = dataProcessingService.dataProcessing(scrapingDto);

        assertThat(responseDataDto.getQuotient()).isEqualTo("A0a1B2C3");
        assertThat(responseDataDto.getRemainder()).isEqualTo("D4");
    }

    private ScrapingDto getScrapingDto(int statusCode, String html, String message) {
        ScrapingDto dto = ScrapingDto.builder()
                .statusCode(statusCode)
                .html(html)
                .message(message)
                .exposureType("HTML 제외")
                .outputUnit(4)
                .build();
        return dto;
    }

}