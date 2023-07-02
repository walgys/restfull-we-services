package com.walgys.restfullwebservices.controllers;

import com.walgys.restfullwebservices.models.user.User;
import com.walgys.restfullwebservices.services.UserDAOService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    private UserDAOService userDAOService;

    public UsersController(UserDAOService userDAOService) {
        this.userDAOService = userDAOService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return UserDAOService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id){
        return userDAOService.findById(id);
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return userDAOService.save(user);
    }
}
