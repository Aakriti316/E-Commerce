package com.microservices.OrderService.exception;

import com.microservices.OrderService.external.response.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomeException.class)
    public ResponseEntity<ErrorResponse> handleCustomeException(CustomeException exception) {
        ErrorResponse body =
                ErrorResponse.builder()
                        .errorCode(exception.getErrorCode())
                        .errorMessage(exception.getMessage())
                        .build();
        return ResponseEntity.badRequest().body(body);

    }
}
