package com.api.urldataprocessing.domain.processing;

import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor

public class Data {
    private final English english;
    private final Numbers numbers;

    public Data(English english, Numbers numbers) {
        this.english = english;
        this.numbers = numbers;
    }

    public static Data of(String html) {
        English english = pickEnglish(html);
        Numbers numbers = pickNumber(html);
    }

    private static English pickEnglish(String html) {
        String enlish = html.replaceAll("^[a-zA-Z]*$", "");
        return new English(enlish);
    }


    public void ascendingSort() {

    }

    public void ChangePrintUnit() {

    }

    public String crossPrint() {

    }


}
