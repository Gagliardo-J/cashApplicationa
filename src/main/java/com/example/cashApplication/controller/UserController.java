package com.example.cashApplication.controller;

import com.example.cashApplication.model.UserDTO;
import com.example.cashApplication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping("/user/create")
    public String createUser(@RequestBody UserDTO userDTO) {
        LOGGER.info("Creating user for " + userDTO);
        Integer savedUser = userService.createUser(userDTO);
        LOGGER.info("User created with ID " + savedUser);
        return "User created with ID " + savedUser;
    }

    @GetMapping("/user")
    public List<UserDTO> getUsers() {
        LOGGER.info("Getting users");

        List<UserDTO> users = userService.getUsers();

        LOGGER.info("Users gotten " + users);
        return users;
    }

    @GetMapping("/user/{id}")
    public UserDTO getUser(@PathVariable("id") Integer id) {
        LOGGER.info("Getting user with ID " + id);
        UserDTO user = userService.getUser(id);
        LOGGER.info("User got " + user);
        return user;
    }

    @DeleteMapping(value = "/user/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id) {

        LOGGER.info("Deleting user with ID " + id);
        String message = userService.deleteUser(id);
        LOGGER.info(message);
        return message;
    }
}
