package com.api.urldataprocessing.presentation;


import com.api.urldataprocessing.domain.processing.Output;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDataDto {

    private String quotient;

    private String remainder;

    public ResponseDataDto(Output output) {
        this.quotient = output.getQuotient();
        this.remainder = output.getRemainder();
    }
}
