package com.edaolin.blog.Exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    public final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ResponseBody
    @ExceptionHandler(value= ExceptionCollection.NotFoundException.class)
    public ResponseEntity<String> NotFoundHandler(HttpServletRequest httpServletRequest, ExceptionCollection.NotFoundException e){
        logger.error("Service Error", e);
        return new ResponseEntity<>(e.uid.toString()+" "+e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ResponseBody
    @ExceptionHandler(value= ExceptionCollection.DuplicatedException.class)
    public ResponseEntity<String> DuplicateHandler(HttpServletRequest httpServletRequest, ExceptionCollection.DuplicatedException e){
        logger.error("Service Error", e);
        return new ResponseEntity<>(e.uid.toString()+" "+e.getMessage(), HttpStatus.CONFLICT);
    }
}
