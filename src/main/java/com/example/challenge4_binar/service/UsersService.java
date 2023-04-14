package com.example.challenge4_binar.service;

import com.example.challenge4_binar.model.Users;
import com.example.challenge4_binar.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersR;

    public List<Users> getAll() {
        return usersR.findAll();
    }

    public List<Users> addAll(List<Users> usersModel) {
        return usersR.saveAll(usersModel);
    }

    public List<Users> updateAll(String username, List<Users> userUpdate) {
        List<Users> usersList = new ArrayList<>();
        for (Users userFromRequest : userUpdate) {
            Users userFromDatabase = usersR.findByUsername(username);
            if (userFromDatabase != null) {
                userFromDatabase.setEmail_address(userFromRequest.getEmail_address());
                userFromDatabase.setPassword(userFromRequest.getPassword());
                usersList.add(usersR.save(userFromDatabase));
            }else{
                throw new NullPointerException("Nilai kosong");
            }
        }
        return usersList;
    }

    public Users findByUsername(String username){
        return usersR.findByUsername(username);
    }

    @Transactional
    public void deleteByUsername(String username){
        usersR.deleteByUsername(username);
    }

}
