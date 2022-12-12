package com.example.day1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcom {

    @GetMapping("/name")
    public String name(){
        return "My name is Turki";
    }
    @GetMapping("/age")
    public String age(){
        return "My age is 27";
    }
    @GetMapping("check/status")
    public String check(){
        return "Evrything OK";
    }
    @GetMapping("health")
    public String health(){
        return "Server health is up and running";
    }



}
