package com.api.urldataprocessing.common.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CommonExceptionAdvice {

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity BadRequestException(final MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fe = bindingResult.getFieldError();
        log.warn("RuntimeException", ex.getMessage());
        if (fe != null) {
            String message = "Request Error" + " " + fe.getField() + "=" + fe.getRejectedValue() + " (" + fe.getDefaultMessage() + ")";
            return ResponseEntity.badRequest().body(message);
        } else {
            return ResponseEntity.badRequest().body(ErrorCode.COMMON_INVALID_PARAM.getErrorMsg());
        }

    }
    
    @ExceptionHandler({
            RuntimeException.class
    })
    public ResponseEntity BadRequestException(final RuntimeException ex) {
        log.warn("RuntimeException", ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
