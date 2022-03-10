package com.api.urldataprocessing.presentation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDataDto {

    private String url;

    private String exposureType;

    private int outputUnit;

}
