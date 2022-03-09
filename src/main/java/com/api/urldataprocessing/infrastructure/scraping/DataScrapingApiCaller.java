package com.api.urldataprocessing.infrastructure.scraping;

import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.presentation.RequestDataDto;

public interface DataScrapingApiCaller {
    ScrapingDto scrap(RequestDataDto requestUrlDataDto);
}
