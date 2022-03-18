package com.prg.springboot.example.controller;


import com.prg.springboot.example.api.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(path = {"/user"})
class UserController {
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping(path = "/{id}", produces = "application/json")
    public User fetchUser(@PathVariable int id) {
        return new User(id, "Gopinatha P R ", "prgopinath@gmail.com");
    }

    @RequestMapping(method = {PUT, POST}, produces = {"application/json", "application/xml"}, consumes = {"application/json", "application/xml"})
    public String put(@RequestBody User user) {
        log.info("Received ${}", user);
        return UUID.randomUUID().toString();
    }

}
