package com.edaolin.blog.Data.Repo;

import com.edaolin.blog.Data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}