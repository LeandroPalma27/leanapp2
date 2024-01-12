package com.leancoder.leanapp2.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import com.leancoder.leanapp2.custom.exceptions.UserNotFoundException;
import com.leancoder.leanapp2.models.errors.ArithmeticCustomException;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorHandlerController {

    Logger logger = LoggerFactory.getLogger(ErrorHandlerController.class);

    @ExceptionHandler({ ArithmeticException.class })
    public ResponseEntity<ArithmeticCustomException> ifArithmeticErrorIsTriggered(Exception ex) {
        logger.info(ex.getMessage());
        return ResponseEntity.internalServerError()
                .body(new ArithmeticCustomException(ex.getMessage(),
                        "Se genero un error en el servidor, al intentar realizar una operacion aritmetica invalida.",
                        HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now().toString()));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Map<String, Object>> if404ErrorIsTriggered(Exception ex, HttpServletRequest response) {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", ex.getMessage());
        body.put("status", (Integer) HttpStatus.NOT_FOUND.value());
        body.put("error", "El recurso solicitado no existe.");
        body.put("path", response.getRequestURL());
        body.put("date", LocalDateTime.now().toString());
        return ResponseEntity.status(404).body(body);
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> ifUserNotFound(UserNotFoundException ex) {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", ex.getMessage());
        return ResponseEntity.status(404).body(body);
    }

}
