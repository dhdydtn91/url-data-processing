package com.api.urldataprocessing.domain.processing;

import lombok.Getter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class English {
    private final List<Alphabet> alphabetList;

    public English(List<Alphabet> alphabetList) {
        this.alphabetList = alphabetList;
    }

    public String output() {
        List<String> collect = alphabetList.stream()
                .map(Alphabet::getAlphabet)
                .collect(toList());
        return String.join("", collect);
    }

    public void ascendingSort() {
        Collections.sort(alphabetList, (Comparator.naturalOrder()));
    }

}
