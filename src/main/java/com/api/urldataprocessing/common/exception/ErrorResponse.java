package com.api.urldataprocessing.common.exception;

import com.api.urldataprocessing.common.response.ErrorCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {

    private String message;
    private int status;
    private List<FieldError> errors;

    public ErrorResponse(String message, int status, List<FieldError> errors) {
        this.message = message;
        this.status = status;
        this.errors = errors;
    }

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public static ErrorResponse of(ErrorCode invalidInputValue) {
        return new ErrorResponse(invalidInputValue.getMessage(), invalidInputValue.getStatus());
    }

    public static ErrorResponse of(String message, ErrorCode invalidInputValue) {
        return new ErrorResponse(message, invalidInputValue.getStatus());
    }

    public static ErrorResponse of(ErrorCode invalidInputValue, BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors()
                .stream()
                .map(FieldError::of)
                .collect(Collectors.toList());
        return new ErrorResponse(invalidInputValue.getMessage(), invalidInputValue.getStatus(), fieldErrors);
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FieldError {
        private String field;
        private String value;
        private String reason;

        public FieldError(String field, String value, String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

        public static FieldError of(org.springframework.validation.FieldError fieldError) {
            return new FieldError(fieldError.getField(), (String) fieldError.getRejectedValue(), fieldError.getDefaultMessage());
        }
    }
}
