package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    // using dependency injection (autowiring)
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Method: Get Request
    // Get all users
    // Route: "/user"
    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    // Method: GET Request
    // Get the user by id
    // Route: "/user/{userId}"
    @GetMapping(path = "{keyword}")
    public List<User> getUserBySearch(@PathVariable("keyword") String keyword ){
        return  userService.getUser(keyword);
    }

    // Method: POST Request
    // Add new user to database
    // Route: "/user"
    @PostMapping
    public List<User> addNewUser(@RequestBody User user){
        userService.addNewUser(user);
        return userService.getUsers();
    }

    // Method: DELETE Request
    // Delete user from database using user_id
    // Route: "/user/{userId}"
    @DeleteMapping(path = "{userId}")
    public List<User> deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUser(userId);
        return userService.getUsers();
    }

    // Method: PUT Request
    // Update email for existing user using user_id
    // Route: "/user/{userId}"
    @PutMapping(path = "{userId}")
    public List<User> updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String email){
        userService.updateUser(userId, email);
        return userService.getUsers();
    }

}
