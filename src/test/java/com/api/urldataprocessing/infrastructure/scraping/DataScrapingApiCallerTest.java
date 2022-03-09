package com.api.urldataprocessing.infrastructure.scraping;

import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.presentation.RequestDataDto;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Description;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DataScrapingApiCallerTest {

    DataScrapingApiCaller dataScrapingApiCaller;

    @Test
    @Description("입력받은 url사이트에서 html을 불러온다.")
    void scrap() {
        //given
        RequestDataDto dto = createDto("https://www.naver.com", "TEXT 전체", 4);

        //when
        dataScrapingApiCaller = new HtmlDataScrapingApiCaller();
        ScrapingDto scrap = dataScrapingApiCaller.scrap(dto);

        //then
        assertThat(scrap.getStatusCode()).isEqualTo(200);
        assertThat(scrap.getHtml()).isNotBlank();
        assertThat(scrap.getMessage()).isEqualTo("OK");
    }

    @Test
    @Description("입력받은 url이 잘못된 경우 예외를 발생한다.")
    void wrongUrl() {

        //given
        RequestDataDto dto = createDto("https://www.test.cm", "TEXT 전체", 4);
        dataScrapingApiCaller = new HtmlDataScrapingApiCaller();


        assertThatThrownBy(() -> {
            dataScrapingApiCaller.scrap(dto); //when
        }).isInstanceOf(RuntimeException.class); //then
    }

    private RequestDataDto createDto(String url, String exposureType, int outputUnit) {

        return RequestDataDto.builder()
                .url(url)
                .exposureType(exposureType)
                .outputUnit(outputUnit)
                .build();
    }
}