package com.edaolin.blog.Service.Impl;

import com.edaolin.blog.Data.Repo.UserRepository;
import com.edaolin.blog.Data.User;
import com.edaolin.blog.Dto.UserDto;
import com.edaolin.blog.Exceptions.ExceptionCollection;
import com.edaolin.blog.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) throws ExceptionCollection.UserNotFoundException {
        User byEmail = userRepository.findByEmail(email);
        if(byEmail == null){
            throw new ExceptionCollection.UserNotFoundException();
        }
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}