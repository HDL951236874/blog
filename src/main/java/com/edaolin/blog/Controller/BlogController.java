package com.edaolin.blog.Controller;

import com.edaolin.blog.Data.Blog;
import com.edaolin.blog.Data.Repo.BlogRepository;
import com.edaolin.blog.Data.Repo.UserRepository;
import com.edaolin.blog.Exceptions.CustomiseException;
import com.edaolin.blog.Exceptions.ExceptionCollection;
import com.edaolin.blog.Service.BlogService;
import com.edaolin.blog.Service.UserService;
import jakarta.validation.constraints.Null;
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

    @RequestMapping(value = "/all_blogs", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> getAllBlogs(){
        List<Blog> allBlogs = blogService.findAllBlogs();
        return new ResponseEntity<>(allBlogs, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}/blogs", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> getAllBlogsByUser(@PathVariable("id") int id) throws CustomiseException {
        List<Blog> blogsByUser;
        blogsByUser = blogService.findUserBlogsByUserId(id);
        return new ResponseEntity<>(blogsByUser, HttpStatus.OK);
    }

    @RequestMapping (value = "/blog/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteBlogById(@PathVariable("id") int id){
        blogService.deleteBlogByBlogId(id);
        return ResponseEntity.ok().body("Delete Successfully");
    }

    @RequestMapping(value = "/blog/{id}",method = RequestMethod.PUT)
    public ResponseEntity<String> updateBlog(@RequestBody Blog blog) throws ExceptionCollection.NotFoundException {
        blogService.updateBlog(blog);
        return ResponseEntity.ok().body("Update Successfully");
    }
}
