package com.edaolin.blog.Exceptions;

/*
* Defined the CustomiseException Class
* */

public class CustomiseException extends RuntimeException{
    Long uid;
    String message;
    public CustomiseException() {
        super();
    }
    public CustomiseException(String message) {
        this.message = message;
    }
    public CustomiseException(Long uid, String message) {
        this.uid = uid;
        this.message = message;
    }
}