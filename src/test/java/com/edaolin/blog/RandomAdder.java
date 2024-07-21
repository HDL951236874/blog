package com.edaolin.blog;

import com.edaolin.blog.Data.Blog;
import com.edaolin.blog.Data.Role;
import com.edaolin.blog.Data.User;
import com.edaolin.blog.Service.BlogService;
import com.edaolin.blog.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class RandomAdder {
    /*
    * This function is used to generate random data in the dataset
    * */

    @Autowired
    BlogService blogService;
    @Autowired
    UserService userService;

    @Test
    public void AddingUsers(){
        User user1 = User.builder().name("Name1").password("Password1").blogs(new ArrayList<Blog>()).role(new Role()).build();
        User user2 = User.builder().name("Name2").password("Password2").blogs(new ArrayList<Blog>()).role(new Role()).build();
        userService.saveUser(user1);
    }
}
