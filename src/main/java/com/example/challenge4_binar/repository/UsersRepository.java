package com.example.challenge4_binar.repository;

import com.example.challenge4_binar.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
