package com.api.urldataprocessing.presentation;

import com.api.urldataprocessing.appliaction.scraping.DataScrapingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UrlDataProcessControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    DataScrapingService dataScrapingService;

    public ObjectMapper objectMapper = new ObjectMapper();

    @DisplayName("정상적인 URL 데이터 가공 테스트")
    @Test
    void urlDataProcessing() throws Exception {
        String url = "https://www.naver.com";
        String exposureType = "TEXT 전체";
        String outputUnit = "4";

        mockMvc.perform(get("/api/v1/urlDataProcess")
                        .param("url", url)
                        .param("exposureType", exposureType)
                        .param("outputUnit", outputUnit))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @DisplayName("빈 데이터가 들어 왔을경우")
    @Test
    void EmptyInputData() throws Exception {
        String url = "";
        String exposureType = "TEXT 전체";
        String outputUnit = "4";

        mockMvc.perform(get("/api/v1/urlDataProcess")
                        .param("url", url)
                        .param("exposureType", exposureType)
                        .param("outputUnit", outputUnit))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}