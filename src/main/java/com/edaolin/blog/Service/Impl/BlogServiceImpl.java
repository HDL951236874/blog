package com.edaolin.blog.Service.Impl;

import com.edaolin.blog.Data.Blog;
import com.edaolin.blog.Data.Repo.BlogRepository;
import com.edaolin.blog.Data.Repo.UserRepository;
import com.edaolin.blog.Data.User;
import com.edaolin.blog.Exceptions.ExceptionCollection;
import com.edaolin.blog.Service.BlogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    private BlogRepository blogRepository;
    private UserRepository userRepository;
    public BlogServiceImpl(BlogRepository blogRepository,
                           UserRepository userRepository){

        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }
    @Override
    public void saveBlog(Blog blog, String email) throws ExceptionCollection.NotFoundException {
        blogRepository.save(blog);
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new ExceptionCollection.NotFoundException("User Not Found");
        }
        List<Blog> blogs = user.getBlogs();
        blogs.add(blog);
        user.setBlogs(blogs);
        userRepository.save(user);

    }

    @Override
    public List<Blog> findByUser(String email) throws ExceptionCollection.NotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new ExceptionCollection.NotFoundException("User Not Found");
        }

        return null;
    }

    @Override
    public List<Blog> findAllBlogs() {
        return null;
    }
}
