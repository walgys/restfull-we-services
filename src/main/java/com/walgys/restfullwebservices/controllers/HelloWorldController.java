package com.walgys.restfullwebservices.controllers;

import com.walgys.restfullwebservices.beans.HelloWorldBean;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
    private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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

    @GetMapping("/hello-world-internationalized")
    public String HelloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "default Message", locale);

    }

}
