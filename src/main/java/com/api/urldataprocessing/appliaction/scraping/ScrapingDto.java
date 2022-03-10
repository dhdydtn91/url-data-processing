package com.api.urldataprocessing.appliaction.scraping;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScrapingDto {

    private int statusCode;
    private String html;
    private String message;
    private String exposureType;
    private int outputUnit;
}
