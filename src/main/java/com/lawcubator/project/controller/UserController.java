package com.lawcubator.project.controller;


import com.lawcubator.project.model.User;
import com.lawcubator.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) throws Exception {
        return userService.registerNewUser(user);
    }


    @GetMapping({"/check"})
    public String check(Authentication auth){
        org.springframework.security.core.userdetails.User loginUser = (org.springframework.security.core.userdetails.User) auth.getPrincipal();
        System.out.println(loginUser.getUsername());
        return "This URL is only accessible to user";
    }

}
