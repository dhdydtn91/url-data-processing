package com.api.urldataprocessing.appliaction.scraping;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScrapingDto {

    private int statusCode;
    @NotNull
    private String html;
    private String message;
}
