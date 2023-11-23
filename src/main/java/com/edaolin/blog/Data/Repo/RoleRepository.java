package com.edaolin.blog.Data.Repo;


import com.edaolin.blog.Data.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}