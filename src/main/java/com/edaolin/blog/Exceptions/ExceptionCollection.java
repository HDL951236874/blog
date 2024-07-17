package com.edaolin.blog.Exceptions;

import lombok.Getter;
import lombok.Setter;

/*
* Customize the exceptions and add the original uid
* */
@Getter
@Setter
public class ExceptionCollection{
//    public enum ERROR_MESSAGE{
//        NOT_FOUND_USER("4040", "Can not find the user"),
//        NOT_FOUND_BLOG("4041", "Can not find the blog"),
//        DUPLICATED_USER_EMAIL("6001","Duplicated user email");
//        final String resCode;
//        final String resMessage;
//
//        ERROR_MESSAGE(String resCode, String resMessage) {
//            this.resCode = resCode;
//            this.resMessage = resMessage;
//        }
//    }

    public static class UserNotFoundException extends CustomiseException{ Long uid=50900509L; String message = "User not found";}
    public static class BlogNotFoundException extends CustomiseException{ Long uid=30934509L; String message = "Blog not found";}
    public static class DuplicatedException extends CustomiseException{ Long uid=94103827L;String message = "Duplicated user";}
}
