package com.crudApi.tester.controller;

import com.crudApi.tester.entity.User;
import com.crudApi.tester.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")  // Base URL for user-related API endpoints
public class UserController {

    @Autowired
    private UserService service;

    // Add a single user
    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return service.saveUser(user);
    }

    // Add multiple users
    @PostMapping("/addAll")
    public List<User> addUsers(@RequestBody List<User> users) {
        return service.saveUsers(users);
    }

    // Get all users
    @GetMapping("/all")
    public List<User> findAllUsers() {
        return service.getUsers();
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public User findUserById(@PathVariable int id) {
        return service.getUserById(id);

    }

    // Update a user
    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    // Delete a user by ID
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return service.deleteUser(id);
    }
}
