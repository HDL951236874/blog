package com.edaolin.blog;


import com.edaolin.blog.Data.Role;
import com.edaolin.blog.Dto.UserDto;
import com.edaolin.blog.Service.BlogService;
import com.edaolin.blog.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;

}
