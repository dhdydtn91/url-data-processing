package com.api.urldataprocessing.domain.processing;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class Data {
    private English english;
    private Numbers numbers;

    public Data(English english, Numbers numbers) {
        this.english = english;
        this.numbers = numbers;
    }

    public static Data of(String html) {
        English english = pickEnglish(html);
        Numbers numbers = pickNumber(html);
        return new Data(english, numbers);
    }

    private static Numbers pickNumber(String html) {
        String number = html.replaceAll("[^0-9]*", "");
        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .map(Number::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Numbers::new));
    }

    private static English pickEnglish(String html) {
        String english = html.replaceAll("[^a-zA-Z]*", "");
        return Arrays.stream(english.split(""))
                .map(Alphabet::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), English::new));
    }

    public void ascendingSort() {
        english.ascendingSort();
        numbers.ascendingSort();
    }

    public void ChangePrintUnit() {

    }

    public String crossPrint() {
        return null;
    }


}
