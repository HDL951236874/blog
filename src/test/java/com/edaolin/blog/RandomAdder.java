package com.edaolin.blog;

import com.edaolin.blog.Data.Blog;
import com.edaolin.blog.Data.Role;
import com.edaolin.blog.Data.User;
import com.edaolin.blog.Service.BlogService;
import com.edaolin.blog.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;


@RunWith( SpringRunner.class )
@SpringBootTest
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
        User user1 = User.builder().name("Name1").password("Password1").email("testmail3").blogs(new ArrayList<Blog>()).role(new Role()).build();
        User user2 = User.builder().name("Name2").password("Password2").email("Testmail4").blogs(new ArrayList<Blog>()).role(new Role()).build();
        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}
