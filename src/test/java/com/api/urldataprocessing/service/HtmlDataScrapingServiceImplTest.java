package com.api.urldataprocessing.service;

import com.api.urldataprocessing.domain.scraping.DataScrapingApiCaller;
import com.api.urldataprocessing.dto.RequestUrlDataDto;
import com.api.urldataprocessing.service.scraping.DataScrapingService;
import com.api.urldataprocessing.service.scraping.HtmlDataScrapingServiceImpl;
import com.api.urldataprocessing.service.scraping.ScrapingDto;
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

    private static final String URL = "https://www.naver.com";
    private static final String EXPOSURETYPE = "TEXT 전체";
    private static final int OUTPUTUNIT = 4;
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
        String html = "<HTML>www.naver.com</HTML>";
        ScrapingDto dto = new ScrapingDto(html);
        RequestUrlDataDto data = RequestUrlDataDto.builder()
                .url(URL)
                .exposureType(EXPOSURETYPE)
                .outputUnit(OUTPUTUNIT)
                .build();

        //when
        when(dataScrapingService.getScrapingData(data)).thenReturn(dto);
        ScrapingDto scrapingData = dataScrapingService.getScrapingData(data);

        //then
        assertThat(scrapingData.getHtml().equals("<HTML>www.naver.com</HTML>"));

    }
}