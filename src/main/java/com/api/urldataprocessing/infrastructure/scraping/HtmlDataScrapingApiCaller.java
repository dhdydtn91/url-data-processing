package com.api.urldataprocessing.infrastructure.scraping;

import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.presentation.RequestUrlDataDto;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class HtmlDataScrapingApiCaller implements DataScrapingApiCaller {
    @Override
    public ScrapingDto scrap(RequestUrlDataDto requestUrlDataDto) {
        int statusCode;
        String html = "";
        String message = "";
        try {
            Connection.Response response = Jsoup.connect(requestUrlDataDto.getUrl())
                    .method(Connection.Method.GET)
                    .userAgent("Mozilla")
                    .timeout(5000)
                    .execute();

            Document doc = response.parse();
            statusCode = response.statusCode();
            message = response.statusMessage();
            html = doc.html();

        } catch (IOException e) {
            throw new RuntimeException("해당 주소의 html을 불러오는데 실패하였습니다.");
        }
        return new ScrapingDto(statusCode, html, message);
    }
}
