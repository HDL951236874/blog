package com.edaolin.blog.Service;

import com.edaolin.blog.Data.Blog;
import com.edaolin.blog.Dto.UserDto;
import com.edaolin.blog.Exceptions.CustomiseException;
import com.edaolin.blog.Exceptions.ExceptionCollection;

import java.util.List;

public interface BlogService {

    void saveBlog(Blog blog, String email) throws ExceptionCollection.NotFoundException;

    List<Blog> findByUser(String Email) throws CustomiseException;
    List<Blog> findAllBlogs();

}
