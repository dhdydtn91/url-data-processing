package com.api.urldataprocessing.appliaction.scraping;

import com.api.urldataprocessing.infrastructure.scraping.DataScrapingApiCaller;
import com.api.urldataprocessing.presentation.RequestDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HtmlDataScrapingServiceImpl implements DataScrapingService {

    private final DataScrapingApiCaller dataScrapingApiCaller;

    @Override
    public ScrapingDto getScrapingData(RequestDataDto requestUrlDataDto) {
        return dataScrapingApiCaller.scrap(requestUrlDataDto);
    }
}
