package com.api.urldataprocessing.infrastructure.scraping;

import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.presentation.RequestUrlDataDto;

public interface DataScrapingApiCaller {
    ScrapingDto scrap(RequestUrlDataDto requestUrlDataDto);
}
