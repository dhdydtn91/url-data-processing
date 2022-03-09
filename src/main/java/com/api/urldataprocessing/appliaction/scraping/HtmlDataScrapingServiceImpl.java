package com.api.urldataprocessing.appliaction.scraping;

import com.api.urldataprocessing.infrastructure.scraping.DataScrapingApiCaller;
import com.api.urldataprocessing.presentation.RequestUrlDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HtmlDataScrapingServiceImpl implements DataScrapingService {

    private final DataScrapingApiCaller dataScrapingApiCaller;

    @Override
    public ScrapingDto getScrapingData(RequestUrlDataDto requestUrlDataDto) {
        return dataScrapingApiCaller.scrap(requestUrlDataDto);
    }
}
