package com.edaolin.blog.Service.Impl;

import com.edaolin.blog.Data.Blog;
import com.edaolin.blog.Data.Repo.BlogRepo;
import com.edaolin.blog.Data.Repo.UserRepo;
import com.edaolin.blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    BlogRepo blogRepo;

    @Override
    public List<Blog> getAllBlogs() {

        return null;
    }

    @Override
    public void deleteBlogById(int id) {

    }

    @Override
    public void addBlog(Blog b) {

    }

    @Override
    public void updateBlogById(int id) {

    }
}
