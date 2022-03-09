package com.api.urldataprocessing.appliaction.scraping;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScrapingDto {

    @NotNull
    private int statusCode;
    @NotNull
    private String html;
    @NotNull
    private String message;
    @NotNull
    private String exposureType;
    @NotNull
    private int outputUnit;
}
