package com.practica.crudoriginal.utilities;
import com.practica.crudoriginal.utilities.ResponseHttpApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException e) {
        logger.error("CustomException: {}", e.getMessage(), e);
        return new ResponseEntity<>(ResponseHttpApi.responseHttpError("¡ERROR!", e.getHttpStatus(), e.getMessage()), e.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
        logger.error("MethodArgumentTypeMismatchException: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ResponseHttpApi.responseHttpError("¡ERROR!", HttpStatus.BAD_REQUEST, "Invalid parameter type."), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
        logger.error("Exception: {}", ex.getMessage(), ex);
        return new ResponseEntity<>(ResponseHttpApi.responseHttpError("¡ERROR!", HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred."), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
