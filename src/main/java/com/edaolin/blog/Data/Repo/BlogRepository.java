package com.edaolin.blog.Data.Repo;

import com.edaolin.blog.Data.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Blog findBlogById(int id);
    Blog findBlogByTitle(String title);
    void deleteAll();
    void deleteById(int id);
    void deleteByTitle(String title);
    void updateBlogById(int id, Blog blog);
    void updateBlogByTitle(String title, Blog blog);
}
