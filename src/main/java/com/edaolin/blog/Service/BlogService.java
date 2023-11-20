package com.edaolin.blog.Service;

import com.edaolin.blog.Data.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> getAllBlogs();
    void deleteBlogById(int id);
    void addBlog(Blog b);
    void updateBlogById(int id);

}
