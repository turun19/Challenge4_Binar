package com.example.challenge4_binar.controller;


import com.example.challenge4_binar.model.Users;
import com.example.challenge4_binar.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UsersController {
    private final Logger logging = Logger.getLogger(UsersController.class.getName());
    @Autowired
    UsersService users;

    @GetMapping
    public List<Users> getAll(){
        logging.info("Sukses Mendapatkan Data User");
        return users.getAll();
    }

    @PostMapping(value = "/users-add")
    public List<Users> addAll(@RequestBody List<Users> userModel){
        logging.info("Sukses menambahkan Data User");
        return users.addAll(userModel);
    }

    @PutMapping(value = "/users-update/{username}")
    public List<Users> updateAll(@PathVariable String username, @RequestBody List<Users> userUpdate) {
        logging.info("Sukses mengupdate Data User");
        return users.updateAll(username, userUpdate);
    }

    @DeleteMapping(value = "/users-delete/{username}")
    public String deleteUserByUsername(@PathVariable("username") String username){
        Users users1 = users.findByUsername(username);
        users.deleteByUsername(users1.getUsername());
        logging.info("Sukses menghapus data dengan username "+ username);
        return "User with username : " +username+ " is deleted";

    }
}

