package pl.java.recruitauthor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Collections;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {AuthorNotFoundException.class, CategoryNotFoundException.class})
    public <T extends RuntimeException> ResponseEntity<ApiError> handleAuthorNotFoundException(T ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, LocalDateTime.now(), ex.getMessage(), Collections.emptyList());

        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }
}
