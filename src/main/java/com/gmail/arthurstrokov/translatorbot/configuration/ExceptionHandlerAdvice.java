package com.gmail.arthurstrokov.translatorbot.configuration;

import com.gmail.arthurstrokov.translatorbot.exceptions.ResourceBadRequestException;
import com.gmail.arthurstrokov.translatorbot.exceptions.ResourceMethodNotAllowedException;
import com.gmail.arthurstrokov.translatorbot.exceptions.ResourceNotFoundException;
import com.gmail.arthurstrokov.translatorbot.exceptions.ResourceUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * @author Arthur Strokov
 * @email arthurstrokov@gmail.com
 * @created 13.11.2022
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler({ResourceBadRequestException.class})
    public ResponseEntity<?> handleResourceBadRequestException(ResourceBadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler({ResourceUnauthorizedException.class})
    public ResponseEntity<?> handleResourceUnauthorizedException(ResourceUnauthorizedException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
    }

    @ExceptionHandler({ResourceMethodNotAllowedException.class})
    public ResponseEntity<?> handleResourceMethodNotAllowedException(ResourceMethodNotAllowedException exception) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(exception.getMessage());
    }
}
