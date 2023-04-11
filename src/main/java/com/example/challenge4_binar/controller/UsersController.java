package com.example.challenge4_binar.controller;


import com.example.challenge4_binar.model.Users;
import com.example.challenge4_binar.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    UsersService users;

    @GetMapping
    public List<Users> getAll(){
        return users.getAll();
    }

    @PostMapping(value = "/users-add")
    public List<Users> addAll(@RequestBody List<Users> userModel){
        return users.addAll(userModel);
    }

    @PutMapping(value = "/users-update/{username}")
    public List<Users> updateAll(@PathVariable String username, @RequestBody List<Users> userUpdate) {
        return users.updateAll(username, userUpdate);
    }
}

