package com.api.urldataprocessing.appliaction.processing;

import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.domain.processing.ExposureType;
import com.api.urldataprocessing.domain.processing.Output;
import com.api.urldataprocessing.domain.processing.ScrapingData;
import com.api.urldataprocessing.presentation.ResponseDataDto;
import org.springframework.stereotype.Service;

@Service
public class DataProcessingService {

    public ResponseDataDto dataProcessing(ScrapingDto dto) {
        ScrapingData scrapingData = ExposureType.getTypeData(dto);
        scrapingData.ascendingSort();
        scrapingData.changeOutputUnit(dto.getOutputUnit());
        Output output = scrapingData.getOutput();
        return new ResponseDataDto(output);
    }
}
