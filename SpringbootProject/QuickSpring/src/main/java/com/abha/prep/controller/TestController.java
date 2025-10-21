package com.abha.prep.controller;

import com.abha.prep.dto.User;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo")
@Validated
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

    @GetMapping(value = "/employee/{date}",
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public String newUser(
            @PathVariable("date")
            @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in YYYY-MM-DD format")
            String date
    ) {
        return "Hello Welcome " + date;
    }

    @PostMapping(value = "/employee1/{date}",
            produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    private String newUser1(
            @PathVariable("date")
            @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date must be in YYYY-MM-DD format")
            String date,
            @RequestBody User user
    ){
        return "Hello Welcome "+date;
    }
}
