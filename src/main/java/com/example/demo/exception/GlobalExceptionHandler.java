package com.example.demo.exception;
import com.example.demo.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;




@ControllerAdvice
public class GlobalExceptionHandler {

    // Handler 1: Missing parameter
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingParam(
            MissingServletRequestParameterException e) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse("Missing parameter: " + e.getParameterName()));
    }

    // Handler 2: Invalid number
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMismatch(
            MethodArgumentTypeMismatchException e) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse("Invalid value: " + e.getValue()));
    }

    // Handler 3: Unknown category or unit
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgument(
            IllegalArgumentException e) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(e.getMessage()));
    }
}
