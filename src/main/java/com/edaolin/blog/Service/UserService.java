package com.edaolin.blog.Service;

import com.edaolin.blog.Data.User;
import com.edaolin.blog.Dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);
    User findByEmail(String email);
    List<UserDto> findAllUsers();
}