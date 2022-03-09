package com.api.urldataprocessing.domain.processing;

import lombok.Getter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class Numbers {

    private final List<Number> numberList;

    public Numbers(List<Number> numberList) {
        this.numberList = numberList;
    }

    public String output() {
        List<String> collect = numberList.stream()
                .map(Number::toString)
                .collect(toList());
        return String.join("", collect);
    }

    public void ascendingSort() {
        Collections.sort(numberList, Comparator.naturalOrder());
    }
}
