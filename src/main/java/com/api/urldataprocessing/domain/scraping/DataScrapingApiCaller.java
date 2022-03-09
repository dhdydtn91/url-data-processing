package com.api.urldataprocessing.domain.scraping;

import com.api.urldataprocessing.dto.RequestUrlDataDto;
import com.api.urldataprocessing.service.scraping.ScrapingDto;

public interface DataScrapingApiCaller {
    ScrapingDto scrap(RequestUrlDataDto requestUrlDataDto);
}
