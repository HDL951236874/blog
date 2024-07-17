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
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

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
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

}