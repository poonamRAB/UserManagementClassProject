package com.geekster.UserManagementSystem.controller;

import com.geekster.UserManagementSystem.model.User;
import com.geekster.UserManagementSystem.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;

    //read
    @GetMapping("users")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //create
    @PostMapping("users")
    String addUsers(@Valid @RequestBody List<User> users){
        return userService.createUsers(users);
    }

    @PostMapping("user")
    String addUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    //delete
    @DeleteMapping("user")
    String removeUser(@RequestParam @Max(10000) Integer userId){
        return userService.removeUser(userId);
    }
    //update
    @RequestMapping(value = "user/{userId}", method = PUT)
    public String updateUserInfo(@PathVariable Integer userId, @PathVariable @Email String userEmail ){
        return userService.updateUserInfo(userId,userEmail);
    }



}
