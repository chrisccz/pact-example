package com.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MessageService {
    @GetMapping(value = "/message", produces = APPLICATION_JSON_VALUE)
    public Message getMessage(){
        return new Message();
    }
}
