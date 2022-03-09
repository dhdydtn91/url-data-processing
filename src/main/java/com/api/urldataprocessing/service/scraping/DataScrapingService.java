package com.api.urldataprocessing.service.scraping;

import com.api.urldataprocessing.dto.RequestUrlDataDto;


public interface DataScrapingService {

    ScrapingDto getScrapingData(RequestUrlDataDto requestUrlDataDto);
}
