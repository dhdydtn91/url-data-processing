package com.api.urldataprocessing.controller;

import com.api.urldataprocessing.dto.RequestUrlDataDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
class UrlDataProcessingControllerTest {

    @Autowired
    MockMvc mockMvc;

    public ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @Description("정상적인 URL 데이터 가공 테스트")
    void urlDataProcessing() throws Exception {
        String url = "https://www.naver.com";
        String exposureType = "TEXT 전체";
        int outputUnit = 4;

        RequestUrlDataDto data = RequestUrlDataDto.builder()
                .url(url)
                .exposureType(exposureType)
                .outputUnit(outputUnit)
                .build();

        mockMvc.perform(get("/api/v1/urlDataProcessing")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(data)))
                .andExpect(status().isOk());
    }

}