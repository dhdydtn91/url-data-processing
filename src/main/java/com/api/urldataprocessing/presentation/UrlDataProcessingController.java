package com.api.urldataprocessing.presentation;

import com.api.urldataprocessing.appliaction.processing.DataProcessingService;
import com.api.urldataprocessing.appliaction.scraping.DataScrapingService;
import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@Slf4j
public class UrlDataProcessingController {

    private final DataScrapingService dataScrapingService;

    private final DataProcessingService dataProcessingService;

    private final UrlDataProcessingValidator urlDataProcessValidator;


    @GetMapping("/urlDataProcess")
    public ResponseEntity urlDataProcess(@RequestParam String url, @RequestParam String exposureType, @RequestParam int outputUnit) {

        RequestDataDto requestDataDto = new RequestDataDto(url, exposureType, outputUnit);
        urlDataProcessValidator.validate(requestDataDto);

        ScrapingDto scrapingData = dataScrapingService.getScrapingData(requestDataDto);

        ResponseDataDto responseDataDto = dataProcessingService.dataProcessing(scrapingData);
        return ResponseEntity.ok().body(responseDataDto);
    }

}
