package com.api.urldataprocessing.appliaction.scraping;

import com.api.urldataprocessing.presentation.RequestDataDto;


public interface DataScrapingService {

    ScrapingDto getScrapingData(RequestDataDto requestUrlDataDto);
}
