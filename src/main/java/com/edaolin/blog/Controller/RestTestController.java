package com.edaolin.blog.Controller;

import com.edaolin.blog.util.ListResponse;
import com.edaolin.blog.util.StringResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestTestController {
    @GetMapping("/rest")
    public ResponseEntity<Map<String, String>> rest(){
        return new ResponseEntity<>(new HashMap<>(){
            {
                put("name","This is a test");
                put("id","This is a test 2");
            }
        }, HttpStatus.OK);
    }
    @GetMapping(value = "/restString", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> restString(){
        return new ResponseEntity<>("This is a test", HttpStatus.OK);
    }
    @GetMapping(value = "/restStringResponse")
    public ResponseEntity<StringResponse> restStringResponse(){
        StringResponse thisIsAMessage = StringResponse.builder().response("This is a message").build();
        return new ResponseEntity<>(thisIsAMessage, HttpStatus.OK) ;
    }
    @GetMapping(value = "/restListResponse")
    public ResponseEntity<ListResponse> restListResponse(){
        ListResponse thisIsAMessage = ListResponse.builder().response(new ArrayList<>(){{add("String1");add("String2");}}).build();
        return new ResponseEntity<>(thisIsAMessage, HttpStatus.OK) ;
    }

}
