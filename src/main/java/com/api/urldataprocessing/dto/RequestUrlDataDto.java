package com.api.urldataprocessing.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class RequestUrlDataDto {

    @NotNull
    private String url;

    @NotNull
    private String exposureType;

    @NotNull
    private int outputUnit;
}
