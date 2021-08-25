package pl.java.recruitauthor.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ApiError {
    private HttpStatus httpStatus;
    private LocalDateTime timeStamp;
    private String message;
    private List<String> errors;
}
