package com.api.urldataprocessing.appliaction.processing;

import com.api.urldataprocessing.appliaction.scraping.ScrapingDto;
import com.api.urldataprocessing.domain.processing.Data;
import com.api.urldataprocessing.domain.processing.ExposureType;
import com.api.urldataprocessing.domain.processing.Output;
import com.api.urldataprocessing.presentation.ResponseDataDto;
import org.springframework.stereotype.Service;

@Service
public class DataProcessingService {

    public ResponseDataDto dataProcessing(ScrapingDto dto) {
        String typeData = ExposureType.getTypeData(dto);
        Data data = Data.of(typeData);
        data.ascendingSort();
        data.changeOutputUnit(dto.getOutputUnit());
        Output output = data.getOutput();
        return new ResponseDataDto(output);
    }
}
