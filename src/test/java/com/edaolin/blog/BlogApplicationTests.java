package com.edaolin.blog;

import com.edaolin.blog.Data.Blog;
import com.edaolin.blog.Data.Repo.BlogRepository;
import com.edaolin.blog.Data.Repo.UserRepository;
import com.edaolin.blog.Dto.UserDto;
import com.edaolin.blog.Exceptions.CustomiseException;
import com.edaolin.blog.Service.BlogService;
import com.edaolin.blog.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;

    @Test
    void contextLoads() {
        UserDto dto = new UserDto(){{setFirstName("Daolin");setLastName("Han");setEmail("daolin970108@gmail.com");setPassword("123");}};
        userService.saveUser(dto);
    }
    @Test
    void AddBlogTest() throws CustomiseException {
        Blog blog = new Blog();
        blog.setPics(null);
        blog.setText("TestText");
        blog.setTitle("TestTitle");
        blogService.saveBlog(blog, "daolin970108@gmail.com");
    }

    @Test
    void deleteBlogTest() throws CustomiseException{
        Blog blog = new Blog();
        blog.setPics(null);
        blog.setText("TextForDelete");
        blog.setTitle("TestTitle");
        blogService.saveBlog(blog, "daolin970108@gmail.com");
        List<Blog> userBlogsByEmail = blogService.findUserBlogsByEmail("daolin970108@gmail.com");
        userBlogsByEmail.stream().filter(b -> b.getText().equals("TextForDelete")).findFirst().ifPresent(b -> {
            blogService.deleteBlogByBlogId(b.getId());
        });

    }
}
