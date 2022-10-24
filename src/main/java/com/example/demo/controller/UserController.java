package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    // using dependency injection (autowiring)
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Method: GET Request
    // Get the user by id
    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        return  userService.getUser(userId);

    }

    // Method: POST Request
    // Add new user to database
    @PostMapping
    public void addNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    // Method: DELETE Request
    // Delete user from database using user_id
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
    }

    // Method: PUT Request
    // Update email for existing user using user_id
    @PutMapping(path = "{userId}")
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String email){
        userService.updateUser(userId, email);
    }

}
