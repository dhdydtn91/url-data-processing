package com.api.urldataprocessing.domain.processing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class DataTest {

    @DisplayName("출력은 영어와 숫자로만 이루어진다.")
    @Test
    void createData() {
        String html = "<HTML>W@e2eAAsc232 34<HTML>";
        Data data = Data.of(html);

        English english = data.getEnglish();
        Numbers numbers = data.getNumbers();

        assertThat(english.output()).isEqualTo("HTMLWeeAAscHTML");
        assertThat(numbers.output()).isEqualTo("223234");
    }

    @DisplayName("오름차순으로 정렬한다.")
    @Test
    void changePrintUnit() {
        String html = "<HTML>W@e2eAAsc232    34<HTML>";
        Data data = Data.of(html);

        data.ascendingSort();
        English english = data.getEnglish();
        Numbers numbers = data.getNumbers();

        assertThat(english.output()).isEqualTo("AAceeHHLLMMsTTW");
        assertThat(numbers.output()).isEqualTo("222334");
    }

    @DisplayName("입력받은 출력단위에 따른 출력값을 만든다.")
    @Test
    void changeOutputUnit() {
        String html = "<HTML>W@e2eAAsc232    34<HTML>";
        Data data = Data.of(html);

        data.ascendingSort();
        data.changeOutputUnit(4);
        Output output = data.getOutput();
        assertThat(output.getTotalStr()).isEqualTo("A2A2c2e3e3H4HLLMMsTTW");
        assertThat(output.getQuotient()).isEqualTo("A2A2c2e3e3H4HLLMMsTT");
        assertThat(output.getRemainder()).isEqualTo("W");
    }
}