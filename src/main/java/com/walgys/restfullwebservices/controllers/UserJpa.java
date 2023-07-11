package com.walgys.restfullwebservices.controllers;

import com.walgys.restfullwebservices.exceptions.UserNotFoundException;
import com.walgys.restfullwebservices.models.user.User;
import com.walgys.restfullwebservices.repositories.IUserRepository;
import com.walgys.restfullwebservices.services.UserDAOService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpa {
    private IUserRepository userRepository;

    public UserJpa( IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id){
        final Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) throw new UserNotFoundException("id: " + id);
        final EntityModel<User> entityModel = EntityModel.of(user.get());
        final WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
        entityModel.add(link.withRel("all_users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(null).location(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }
}
