package com.api.urldataprocessing.presentation;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class RequestDataDto {

    @NotNull
    private String url;

    @NotNull
    private String exposureType;

    @NotNull
    private int outputUnit;

}