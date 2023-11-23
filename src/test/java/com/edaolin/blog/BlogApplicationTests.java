package com.edaolin.blog;

import com.edaolin.blog.Data.Repo.UserRepository;
import com.edaolin.blog.Dto.UserDto;
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
    @Test
    void contextLoads() {
        UserDto dto = new UserDto(){{setFirstName("Daolin");setLastName("Han");setEmail("daolin970108@gmail.com");setPassword("123");}};
        userService.saveUser(dto);
        System.out.println(userRepository.findByEmail("daolin970108@gmail.com").getName());
    }

}
