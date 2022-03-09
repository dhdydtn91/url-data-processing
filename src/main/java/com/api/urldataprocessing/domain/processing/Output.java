package com.api.urldataprocessing.domain.processing;

import lombok.Getter;

import java.util.Queue;

@Getter
public class Output {

    private final String totalStr;

    private final String quotient;

    private final String remainder;

    public Output(String totalStr, String quotient, String remainder) {
        this.totalStr = totalStr;
        this.quotient = quotient;
        this.remainder = remainder;
    }

    public static Output of(Queue<Alphabet> englishQueue, Queue<Number> numberQueue, int outputUnit) {
        String totalStr = createTotalStr(englishQueue, numberQueue);
        int remainderLength = totalStr.length() % outputUnit;
        int quotientLength = totalStr.length() - remainderLength;
        return new Output(totalStr, totalStr.substring(0, quotientLength), totalStr.substring(quotientLength));
    }

    private static String createTotalStr(Queue<Alphabet> englishQueue, Queue<Number> numberQueue) {
        String total = "";
        int minQueueSize = Math.min(englishQueue.size(), numberQueue.size());
        int maxQueueSize = Math.max(englishQueue.size(), numberQueue.size());
        for (int i = 0; i < maxQueueSize; i++) {
            if (i < minQueueSize) {
                total += englishQueue.poll().getAlphabet();
                total += numberQueue.poll().toString();
            } else {
                total += englishQueue.size() > numberQueue.size() ? englishQueue.poll().getAlphabet() : numberQueue.poll().toString();
            }
        }
        return total;
    }
}
