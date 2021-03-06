package com.api.urldataprocessing.service;

import com.api.urldataprocessing.appliaction.processing.DataProcessingService;
import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.presentation.ResponseDataDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.api.urldataprocessing.appliaction.scraping.ScrapingDto.builder;
import static org.assertj.core.api.Assertions.assertThat;

class DataProcessingServiceTest {

    DataProcessingService dataProcessingService;

    @DisplayName("url로 가져온 HTML에서 태그를 제외한 데이터를 가공한다.")
    @Test
    void dataProcessing_HTML_TAG_EXCLUDE() {
        dataProcessingService = new DataProcessingService();
        int statusCode = 200;
        String html = "<HTML>AaBbCD01234</HTML>";
        String message = "success";
        String exposureType = "TEXT 전체";

        ScrapingDto scrapingDto = getScrapingDto(statusCode, html, message, exposureType);

        ResponseDataDto responseDataDto = dataProcessingService.dataProcessing(scrapingDto);

        assertThat(responseDataDto.getQuotient()).isEqualTo("A0a1B2b3C4DHHLLM");
        assertThat(responseDataDto.getRemainder()).isEqualTo("MTT");
    }

    @DisplayName("url로 가져온 HTML 전체 데이터를 가공한다.")
    @Test
    void dataProcessing_TEXT_ALL() {
        dataProcessingService = new DataProcessingService();
        int statusCode = 200;
        String html = "<HTML>AaBbCD01234</HTML>";
        String message = "success";
        String exposureType = "HTML 태그 제외";

        ScrapingDto scrapingDto = getScrapingDto(statusCode, html, message, exposureType);

        ResponseDataDto responseDataDto = dataProcessingService.dataProcessing(scrapingDto);

        assertThat(responseDataDto.getQuotient()).isEqualTo("A0a1B2b3");
        assertThat(responseDataDto.getRemainder()).isEqualTo("C4D");
    }
    
    private ScrapingDto getScrapingDto(int statusCode, String html, String message, String exposureType) {
        return builder()
                .statusCode(statusCode)
                .html(html)
                .message(message)
                .exposureType(exposureType)
                .outputUnit(4)
                .build();
    }

}