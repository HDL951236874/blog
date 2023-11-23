package com.edaolin.blog;

import com.edaolin.blog.Data.Blog;
import com.edaolin.blog.Data.Repo.BlogRepository;
import com.edaolin.blog.Data.Repo.UserRepository;
import com.edaolin.blog.Dto.UserDto;
import com.edaolin.blog.Exceptions.CustomiseException;
import com.edaolin.blog.Exceptions.ExceptionCollection;
import com.edaolin.blog.Service.BlogService;
import com.edaolin.blog.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    BlogService blogService;
    @Autowired
    BlogRepository blogRepository;
    @Test
    void contextLoads() {
        UserDto dto = new UserDto(){{setFirstName("Daolin");setLastName("Han");setEmail("daolin970108@gmail.com");setPassword("123");}};
        userService.saveUser(dto);
        System.out.println(userRepository.findByEmail("daolin970108@gmail.com").getName());
    }
    @Test
    void AddBlogTest() throws CustomiseException {
        blogService.deleteBlogByBlogId(10461);
    }
}
