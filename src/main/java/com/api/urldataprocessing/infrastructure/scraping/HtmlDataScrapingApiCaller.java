package com.api.urldataprocessing.infrastructure.scraping;

import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.common.exception.ScrapingFailException;
import com.api.urldataprocessing.common.response.ErrorCode;
import com.api.urldataprocessing.presentation.RequestDataDto;
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
    public ScrapingDto scrap(RequestDataDto requestUrlDataDto) {
        int statusCode;
        String html;
        String message;
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
            throw new ScrapingFailException(requestUrlDataDto.getUrl(), ErrorCode.FAILED_HTML_SCRAPING);
        }
        return ScrapingDto.builder()
                .statusCode(statusCode)
                .html(html)
                .message(message)
                .exposureType(requestUrlDataDto.getExposureType())
                .outputUnit(requestUrlDataDto.getOutputUnit())
                .build();
    }
}
