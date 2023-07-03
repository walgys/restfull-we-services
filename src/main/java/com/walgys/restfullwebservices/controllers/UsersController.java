package com.walgys.restfullwebservices.controllers;

import com.walgys.restfullwebservices.exceptions.UserNotFoundException;
import com.walgys.restfullwebservices.models.user.User;
import com.walgys.restfullwebservices.services.UserDAOService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = userDAOService.findById(id);
        if(user == null) throw new UserNotFoundException("id: " + id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        User savedUser = userDAOService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(null).location(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userDAOService.deleteById(id);
    }
}
