package com.edaolin.blog.Exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*
* Used to handle the global exceptions
* */
@RestControllerAdvice
public class GlobalExceptionHandler {
    public final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(value= ExceptionCollection.UserNotFoundException.class)
    public ResponseEntity<String> UserNotFoundHandler(ExceptionCollection.UserNotFoundException e){
        String info = e.uid.toString()+" "+e.message;
        logger.error(info, e);
        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value= ExceptionCollection.BlogNotFoundException.class)
    public ResponseEntity<String> BlogNotFoundHandler(ExceptionCollection.BlogNotFoundException e){
        String info = e.uid.toString()+" "+e.message;
        logger.error(info, e);
        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value= ExceptionCollection.DuplicatedException.class)
    public ResponseEntity<String> DuplicateHandler(ExceptionCollection.DuplicatedException e){
        String info = e.uid.toString()+" "+e.message;
        logger.error(info, e);
        return new ResponseEntity<>(info, HttpStatus.CONFLICT);
    }
}
