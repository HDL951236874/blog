package com.edaolin.blog.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {
    @GetMapping("/rest")
    public ResponseEntity<String> rest(){
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
