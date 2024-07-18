package com.edaolin.blog.Controller;

import com.edaolin.blog.Data.User;
import com.edaolin.blog.Dto.UserDto;
import com.edaolin.blog.Exceptions.ExceptionCollection;
import com.edaolin.blog.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthController {
    @Autowired
    UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public ResponseEntity<String> registration(@Valid @ModelAttribute("user") UserDto user, BindingResult result) throws ExceptionCollection.UserNotFoundException {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors().toString());
        }
        userService.saveUser(user);
        return ResponseEntity.ok().body("Register Success");
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> listRegisteredUsers(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}