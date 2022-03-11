package com.api.urldataprocessing.domain.processing;

import com.api.urldataprocessing.common.util.StringExtractUtils;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class HtmlTagExcludeData implements ScrapingData {

    private Output output;
    private English english;
    private Numbers numbers;

    public HtmlTagExcludeData(English english, Numbers numbers) {
        this.english = english;
        this.numbers = numbers;
    }

    public static HtmlTagExcludeData of(String data) {
        String nonHtmlTagString = StringExtractUtils.extractNonHtmlTag(data);
        English english = pickEnglish(nonHtmlTagString);
        Numbers numbers = pickNumber(nonHtmlTagString);
        return new HtmlTagExcludeData(english, numbers);
    }

    private static Numbers pickNumber(String nonHtmlTagString) {
        String number = StringExtractUtils.extractNumbers(nonHtmlTagString);
        return Arrays.stream(number.split(""))
                .map(Integer::parseInt)
                .map(Number::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Numbers::new));
    }

    private static English pickEnglish(String nonHtmlTagString) {
        String english = StringExtractUtils.extractEnglish(nonHtmlTagString);
        return Arrays.stream(english.split(""))
                .map(Alphabet::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), English::new));
    }

    public void ascendingSort() {
        english.ascendingSort();
        numbers.ascendingSort();
    }

    public void changeOutputUnit(int outputUnit) {
        Queue<Alphabet> englishQueue = new LinkedList(english.getAlphabetList());
        Queue<Number> numberQueue = new LinkedList(numbers.getNumberList());
        this.output = Output.of(englishQueue, numberQueue, outputUnit);
    }
}
