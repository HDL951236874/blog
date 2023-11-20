package com.edaolin.blog.Data.Repo;

import com.edaolin.blog.Data.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepo extends JpaRepository<Blog, Integer> {
}
