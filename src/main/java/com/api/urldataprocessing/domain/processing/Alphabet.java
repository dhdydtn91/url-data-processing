package com.api.urldataprocessing.domain.processing;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@EqualsAndHashCode
@ToString
public class Alphabet implements Comparable<Alphabet> {
    private final String alphabet;
    private final static Map<String, Alphabet> map = new HashMap<>();

    static {
        for (char i = 'a'; i <= 'z'; i++) {
            String alpa = String.valueOf(i);
            map.put(alpa, new Alphabet(alpa));
        }

        for (char i = 'A'; i <= 'Z'; i++) {
            String alpa = String.valueOf(i);
            map.put(alpa, new Alphabet(alpa));
        }
    }

    public static Alphabet of(String alphabet) {
        return map.get(alphabet);
    }

    public Alphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public int compareTo(Alphabet alphabet) {
        int res = this.alphabet.compareToIgnoreCase(alphabet.alphabet);
        return (res == 0) ? this.alphabet.compareTo(alphabet.alphabet) : res;
    }

}
