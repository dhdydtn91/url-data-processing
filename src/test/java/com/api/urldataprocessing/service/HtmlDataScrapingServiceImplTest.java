package com.api.urldataprocessing.service;

import com.api.urldataprocessing.appliaction.scraping.DataScrapingService;
import com.api.urldataprocessing.appliaction.scraping.HtmlDataScrapingServiceImpl;
import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.infrastructure.scraping.DataScrapingApiCaller;
import com.api.urldataprocessing.presentation.RequestDataDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class HtmlDataScrapingServiceImplTest {

    DataScrapingService dataScrapingService;

    @Mock
    DataScrapingApiCaller dataScrapingApiCaller;

    @BeforeEach
    void setup() {
        dataScrapingService = new HtmlDataScrapingServiceImpl(dataScrapingApiCaller);
    }

    @DisplayName("요청받은 url의 사이트 html 데이터를 스크래핑 해온다.")
    @Test
    void getScrapingData() {
        //given
        int statusCode = 200;
        String html = "<HTML>www.naver.com</HTML>";
        String message = "success";
        RequestDataDto requestDataDto = createDto();
        ScrapingDto scrapingDto = getScrapingDto(statusCode, html, message, requestDataDto);

        //when
        when(dataScrapingService.getScrapingData(requestDataDto)).thenReturn(scrapingDto);
        ScrapingDto scrapingData = dataScrapingService.getScrapingData(requestDataDto);

        //then
        assertThat(scrapingData.getStatusCode()).isEqualTo(200);
        assertThat(scrapingData.getHtml().equals("<HTML>www.naver.com</HTML>"));
    }

    private ScrapingDto getScrapingDto(int statusCode, String html, String message, RequestDataDto data) {
        ScrapingDto dto = ScrapingDto.builder()
                .statusCode(statusCode)
                .html(html)
                .message(message)
                .exposureType(data.getExposureType())
                .outputUnit(data.getOutputUnit())
                .build();
        return dto;
    }

    private RequestDataDto createDto() {
        String url = "https://www.naver.com";
        String exposureType = "TEXT 전체";
        int outputUnit = 4;
        return RequestDataDto.builder()
                .url(url)
                .exposureType(exposureType)
                .outputUnit(outputUnit)
                .build();
    }
}