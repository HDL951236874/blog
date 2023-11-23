package com.edaolin.blog.Exceptions;

class customiseException extends Exception{
    Long uid;

    public customiseException() {
        super();
    }
    public customiseException(String message) {
        super(message);
    }
}
public class ExceptionCollection{
    public static class NotFoundException extends customiseException{ Long uid = 123123165165161L;
        public NotFoundException(String message) {
            super(message);
        }
    }
}
