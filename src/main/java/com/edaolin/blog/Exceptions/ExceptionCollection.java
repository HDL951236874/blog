package com.edaolin.blog.Exceptions;


public class ExceptionCollection{
    public static class NotFoundException extends CustomiseException{ Long uid=50900509L;
        public NotFoundException(String message) { super(message); }
    }
    public static class DuplicatedException extends CustomiseException{  Long uid=94103827L;
        public DuplicatedException(String message) { super(message); }
    }
}
