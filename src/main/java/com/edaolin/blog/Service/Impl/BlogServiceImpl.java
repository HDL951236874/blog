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
    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    public BlogServiceImpl(BlogRepository blogRepository,
                           UserRepository userRepository){

        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void saveBlog(Blog blog, String email) throws ExceptionCollection.UserNotFoundException {
        blogRepository.save(blog);
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new ExceptionCollection.UserNotFoundException();
        }
        List<Blog> blogs = user.getBlogs();
        blogs.add(blog);
        user.setBlogs(blogs);
        userRepository.save(user);
    }

    @Override
    public void updateBlog(Blog blog) throws ExceptionCollection.BlogNotFoundException {
        Blog blogById = blogRepository.findBlogById(blog.getId());
        if(blogById == null){
            throw new ExceptionCollection.BlogNotFoundException();
        }
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findUserBlogsByEmail(String email) throws ExceptionCollection.UserNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            throw new ExceptionCollection.UserNotFoundException();
        }
        return user.getBlogs();
    }

    @Override
    public List<Blog> findUserBlogsByUserId(int id) throws ExceptionCollection.UserNotFoundException {
        User user = userRepository.findById(id);
        if(user == null){
            throw new ExceptionCollection.UserNotFoundException();
        }
        return user.getBlogs();
    }

    @Override
    public List<Blog> findAllBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public void deleteBlogByBlogId(int id) {
        blogRepository.deleteById(id);
    }
}
