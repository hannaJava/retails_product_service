package com.labiba.ProductService.exception;

import com.labiba.ProductService.model.ProductServiceExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//spring boot global exception handling
public class GlobalExceptionHandler {//extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ProductServiceException.class)
        public ResponseEntity<ProductServiceExceptionResponse> productServiceExceptionHandler(ProductServiceException exception){
                return new ResponseEntity<>(new ProductServiceExceptionResponse().builder()
                        .errorMessage(exception.getMessage())
                        .errorCode(exception.getErrorCode()).build()
                        , HttpStatus.NOT_FOUND);
        }
}
