package com.example.challenge4_binar.service;

import com.example.challenge4_binar.model.Users;
import com.example.challenge4_binar.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                userFromDatabase.setUsername(userFromRequest.getUsername());
                userFromDatabase.setEmail_address(userFromRequest.getEmail_address());
                userFromDatabase.setPassword(userFromRequest.getPassword());
                usersList.add(usersR.save(userFromDatabase));
            }else{
                throw new NullPointerException("Nilai kosong");
            }
        }
        return usersList;
    }


//    public List<Users> updateAll(List<Users> userUpdate) {
//        List<Users> usersList = new ArrayList<>();
//        for (Users userFromRequest : userUpdate) {
//            Users userFromDatabase = usersR.findByUsername(userFromRequest.getUsername());
//            if (userFromDatabase != null) {
//                userFromDatabase.setUsername(userFromRequest.getUsername());
//                userFromDatabase.setEmail_address(userFromRequest.getEmail_address());
//                userFromDatabase.setPassword(userFromRequest.getPassword());
//                usersList.add(usersR.save(userFromDatabase));
//            }else{
//                throw new NullPointerException("Nilai kosong");
//            }
//        }
//        return usersList;
//    }




//    public Users updateAll(@PathVariable String username, Users userUpdate) {
//        Users users =usersR.findByUsername(username);
//        users.setUsername(userUpdate.getUsername());
//        users.setPassword(userUpdate.getPassword());
//        users.setEmail_address(userUpdate.getEmail_address());
//        return usersR.save(userUpdate);
//    }
}
