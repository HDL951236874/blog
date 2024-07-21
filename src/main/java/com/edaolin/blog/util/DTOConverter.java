package com.edaolin.blog.util;

import com.edaolin.blog.Data.User;
import com.edaolin.blog.Dto.UserDto;

public class DTOConverter {
    public static User convertDtoToEntity(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getFirstName()+" "+userDto.getLastName());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
