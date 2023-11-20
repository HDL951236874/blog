package com.edaolin.blog.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//This controller is used to test Spring security
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "welcome daolin.com";
    }
    @GetMapping("/home")
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("This is the home page", HttpStatus.OK);
    }
}