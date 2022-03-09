package com.api.urldataprocessing.service.scraping;

import com.api.urldataprocessing.domain.scraping.DataScrapingApiCaller;
import com.api.urldataprocessing.dto.RequestUrlDataDto;
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
