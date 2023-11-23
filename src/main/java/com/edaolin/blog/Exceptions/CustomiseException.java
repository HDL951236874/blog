package com.edaolin.blog.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomiseException extends Exception{
    Long uid;
    public CustomiseException() {
        super();
    }
    public CustomiseException(String message) {
        super(message);
    }
}