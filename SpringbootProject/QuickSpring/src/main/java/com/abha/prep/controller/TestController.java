package com.abha.prep.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class TestController {

    @GetMapping("/sayHello")
    private String sayHello(){
        return "Hello Welcome Aasif";
    }

    @GetMapping("/say_something/{name}")
    private String sayHello(@PathVariable String name){
        return "Hello Welcome "+name;
    }

    @GetMapping("/say_some/{name_n}")
    private String sayNewHello(@PathVariable("name_n") String firstName){
        return "Hello Welcome "+firstName;
    }
}
