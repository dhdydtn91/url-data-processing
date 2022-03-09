package com.api.urldataprocessing.domain.processing;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@EqualsAndHashCode
public class Number implements Comparable<Number> {

    private final Integer number;
    private static Map<Integer, Number> map = new HashMap<>();

    static {
        for (int i = 0; i < 10; i++) {
            map.put(i, new Number(i));
        }
    }

    public static Number of(Integer number) {
        if (0 > number || number > 9) {
            throw new RuntimeException("숫자의 범위는 0~9까지입니다.");
        }
        return map.get(number);
    }

    public Number(Integer number) {
        this.number = number;
    }

    @Override
    public int compareTo(Number otherNumber) {
        return this.number - otherNumber.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
