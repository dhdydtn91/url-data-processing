package com.api.urldataprocessing.presentation;

import com.api.urldataprocessing.appliaction.scraping.DataScrapingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UrlDataProcessControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    DataScrapingService dataScrapingService;

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

    @DisplayName("url이 비었을때 400에러 발생")
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
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("status").value(400))
                .andExpect(jsonPath("message").value("Url은 유효하지 않는 입력값 입니다."));
    }

    @DisplayName("exposureType이 유효한 값이 아닐때 400에러 발생")
    @Test
    void InvalidInputData() throws Exception {
        String url = "https://www.naver.com";
        String exposureType = "CSS태그만 제거";
        String outputUnit = "4";

        mockMvc.perform(get("/api/v1/urlDataProcess")
                        .param("url", url)
                        .param("exposureType", exposureType)
                        .param("outputUnit", outputUnit))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("status").value(400))
                .andExpect(jsonPath("message").value("ExposureType은 유효하지 않는 입력값 입니다."));
    }

    @DisplayName("outputUnit이 0 보다 작을때 400에러 발생")
    @Test
    void InvalidInputData2() throws Exception {
        String url = "https://www.naver.com";
        String exposureType = "TEXT 전체";
        String outputUnit = "-1";

        mockMvc.perform(get("/api/v1/urlDataProcess")
                        .param("url", url)
                        .param("exposureType", exposureType)
                        .param("outputUnit", outputUnit))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("status").value(400))
                .andExpect(jsonPath("message").value("outputUnit은 유효하지 않는 입력값 입니다."));
    }
}