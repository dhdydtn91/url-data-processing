package com.api.urldataprocessing.service;

import com.api.urldataprocessing.appliaction.scraping.DataScrapingService;
import com.api.urldataprocessing.appliaction.scraping.HtmlDataScrapingServiceImpl;
import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.infrastructure.scraping.DataScrapingApiCaller;
import com.api.urldataprocessing.presentation.RequestUrlDataDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Description;

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

    @Test
    @Description("요청받은 url의 사이트 html 데이터를 스크래핑 해온다.")
    void getScrapingData() {
        //given
        int statusCode = 200;
        String html = "<HTML>www.naver.com</HTML>";
        String message = "success";
        ScrapingDto dto = new ScrapingDto(statusCode, html, message);
        RequestUrlDataDto data = createDto();

        //when
        when(dataScrapingService.getScrapingData(data)).thenReturn(dto);
        ScrapingDto scrapingData = dataScrapingService.getScrapingData(data);

        //then
        assertThat(scrapingData.getStatusCode()).isEqualTo(200);
        assertThat(scrapingData.getHtml().equals("<HTML>www.naver.com</HTML>"));
    }
    
    private RequestUrlDataDto createDto() {
        String url = "https://www.naver.com";
        String exposureType = "TEXT 전체";
        int outputUnit = 4;
        return RequestUrlDataDto.builder()
                .url(url)
                .exposureType(exposureType)
                .outputUnit(outputUnit)
                .build();
    }
}