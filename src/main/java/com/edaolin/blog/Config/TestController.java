package com.edaolin.blog.Config;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/home")
    public ResponseEntity<String> success(){

        return new ResponseEntity<>("Login success!", HttpStatus.OK);
    }
}
