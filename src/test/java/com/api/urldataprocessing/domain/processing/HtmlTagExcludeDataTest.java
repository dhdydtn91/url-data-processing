package com.api.urldataprocessing.domain.processing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HtmlTagExcludeDataTest {


    @DisplayName("출력은 HTML태그를 제외한 영어와 숫자로만 이루어진다.")
    @Test
    void createData() {
        String html = "<HTML>W@e2eAAsc232 34<HTML>";
        ScrapingData data = HtmlTagExcludeData.of(html);

        English english = data.getEnglish();
        Numbers numbers = data.getNumbers();

        assertThat(english.output()).isEqualTo("WeeAAsc");
        assertThat(numbers.output()).isEqualTo("223234");
    }

    @DisplayName("오름차순으로 정렬한다.")
    @Test
    void changePrintUnit() {
        String html = "<HTML>W@e2eAAsc232    34<HTML>";
        ScrapingData data = HtmlTagExcludeData.of(html);

        data.ascendingSort();
        English english = data.getEnglish();
        Numbers numbers = data.getNumbers();

        assertThat(english.output()).isEqualTo("AAceesW");
        assertThat(numbers.output()).isEqualTo("222334");
    }

    @DisplayName("출력 묶음에 따라 HTML태그를 제외한 출력값을 만든다.")
    @Test
    void changeOutputUnit() {
        String html = "<HTML>W@e2eAAsc232    34<HTML>";
        ScrapingData data = HtmlTagExcludeData.of(html);

        data.ascendingSort();
        data.changeOutputUnit(4);
        Output output = data.getOutput();
        assertThat(output.getTotalStr()).isEqualTo("A2A2c2e3e3s4W");
        assertThat(output.getQuotient()).isEqualTo("A2A2c2e3e3s4");
        assertThat(output.getRemainder()).isEqualTo("W");
    }
}