package com.edaolin.blog.Data.Repo;

import com.edaolin.blog.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByName(String name);

}
