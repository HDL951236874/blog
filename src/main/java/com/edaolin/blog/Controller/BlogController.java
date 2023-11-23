package com.edaolin.blog.Controller;

import com.edaolin.blog.Data.Blog;
import com.edaolin.blog.Data.Repo.BlogRepository;
import com.edaolin.blog.Data.Repo.UserRepository;
import com.edaolin.blog.Exceptions.CustomiseException;
import com.edaolin.blog.Service.BlogService;
import com.edaolin.blog.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    private UserRepository userRepository;
    private BlogRepository blogRepository;
    private UserService userService;
    private BlogService blogService;

    public BlogController(UserRepository userRepository, BlogRepository blogRepository, UserService userService, BlogService blogService) {
        this.userRepository = userRepository;
        this.blogRepository = blogRepository;
        this.userService = userService;
        this.blogService = blogService;
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs(){
        List<Blog> allBlogs = blogService.findAllBlogs();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
    }

    @GetMapping("/blogs/{email}")
    public ResponseEntity<List<Blog>> getAllBlogsByUser(@PathVariable("email") String email) throws CustomiseException {
        List<Blog> blogsByUser;
        blogsByUser = blogService.findByUser(email);
        return new ResponseEntity<>(blogsByUser, HttpStatus.OK);
    }
}
