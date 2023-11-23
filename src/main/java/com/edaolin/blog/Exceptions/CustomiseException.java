package com.edaolin.blog.Exceptions;

public class CustomiseException extends Exception{
    Long uid;

    public CustomiseException() {
        super();
    }
    public CustomiseException(String message) {
        super(message);
    }
}