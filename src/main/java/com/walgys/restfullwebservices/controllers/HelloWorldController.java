package com.walgys.restfullwebservices.controllers;

import com.walgys.restfullwebservices.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello-world")
    public String HelloWorld(){
        return "Hello world";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean HelloWorldBean(){
        return new HelloWorldBean("Hello world bean");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean HelloWorldPAthVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello world %s", name));
    }

}
