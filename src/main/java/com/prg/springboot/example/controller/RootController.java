package com.prg.springboot.example.controller;

import com.google.common.collect.ImmutableMap;

import com.prg.springboot.example.service.ExampleService;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RootController {

    @Autowired
    ExampleService exampleService;

    @RequestMapping(path = {"/"}, method = {GET}, produces = {"application/json"})
    public ImmutableMap<Object, Object> example() {
        exampleService.someServiceMethod();
        return ImmutableMap.builder().put("message", "Java rocks!").put("today", LocalDateTime.now().toString()).build();
    }
}
