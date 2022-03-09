package com.api.urldataprocessing.presentation;

import com.api.urldataprocessing.appliaction.processing.DataProcessingService;
import com.api.urldataprocessing.appliaction.scraping.DataScrapingService;
import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UrlDataProcessingController {

    private final DataScrapingService dataScrapingService;

    private final DataProcessingService dataProcessingService;


    @GetMapping("/urlDataProcessing")
    public ResponseEntity urlDataProcessing(@RequestBody @Valid RequestDataDto requestUrlData) {

        ScrapingDto scrapingData = dataScrapingService.getScrapingData(requestUrlData);

        return ResponseEntity.ok().build();
    }

}
