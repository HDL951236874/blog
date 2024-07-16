package com.edaolin.blog;

import com.edaolin.blog.Service.BlogService;
import com.edaolin.blog.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

@Component
public class RandomAdder {
    /*
    * This function is used to generate random data in the dataset
    * */

    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;

}
