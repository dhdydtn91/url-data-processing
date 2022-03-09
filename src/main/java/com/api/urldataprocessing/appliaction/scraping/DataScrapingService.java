package com.api.urldataprocessing.appliaction.scraping;

import com.api.urldataprocessing.presentation.RequestUrlDataDto;


public interface DataScrapingService {

    ScrapingDto getScrapingData(RequestUrlDataDto requestUrlDataDto);
}
