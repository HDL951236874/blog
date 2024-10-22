package com.edaolin.blog.Service;

import com.edaolin.blog.Data.Blog;
import com.edaolin.blog.Exceptions.CustomiseException;
import com.edaolin.blog.Exceptions.ExceptionCollection;

import java.util.List;

public interface BlogService {

    void saveBlog(Blog blog, String email) throws CustomiseException;
    List<Blog> findUserBlogsByEmail(String email) throws ExceptionCollection.UserNotFoundException;
    List<Blog> findUserBlogsByUserId(int id) throws ExceptionCollection.UserNotFoundException;
    List<Blog> findAllBlogs();
    void deleteBlogByBlogId(int id);
    void updateBlog(Blog blog) throws ExceptionCollection.BlogNotFoundException;
}
