package com.api.urldataprocessing.domain.processing;

public interface ScrapingData {

    void ascendingSort();

    void changeOutputUnit(int outputUnit);

    Output getOutput();

    Numbers getNumbers();

    English getEnglish();
}
