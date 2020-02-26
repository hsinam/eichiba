package com.eichiba.demo.controllers;

import com.eichiba.demo.service.UserService;
import com.eichiba.demo.entitys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user/save", method = RequestMethod.PUT, consumes = "application/json")
    public User putUserDetails(@RequestBody @Valid User user){
        return userService.saveUser(user);
    }

    @RequestMapping(path = "/user/{id}" , method = RequestMethod.GET, consumes = "application/json")
    public User getUserDetails(@PathVariable(value = "id") String id){
        return userService.getUser(id);
    }
}
