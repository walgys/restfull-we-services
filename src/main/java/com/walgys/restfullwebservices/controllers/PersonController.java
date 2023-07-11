package com.walgys.restfullwebservices.controllers;

import com.walgys.restfullwebservices.models.person.Name;
import com.walgys.restfullwebservices.models.person.Personv1;
import com.walgys.restfullwebservices.models.person.Personv2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/v1/person")
    public Personv1 getPersonV1(){
        return new Personv1("Bob charlie");
    }

    @GetMapping("/v2/person")
    public Personv2 getPersonV2(){
        return new Personv2(new Name("Bob", "charlie"));
    }

    @GetMapping(path = "/person", params = "version=1")
    public Personv1 getPersonParamsV1(){
        return new Personv1("Bob charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public Personv2 getPersonParamsV2(){
        return new Personv2(new Name("Bob", "charlie"));
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=1")
    public Personv1 getPersonHeadersV1(){
        return new Personv1("Bob charlie");
    }

    @GetMapping(path = "/person", headers = "X-API-VERSION=2")
    public Personv2 getPersonHeadersV2(){
        return new Personv2(new Name("Bob", "charlie"));
    }


}
