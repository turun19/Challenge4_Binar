package com.example.challenge4_binar.repository;

import com.example.challenge4_binar.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    Users findByUsername(String username);

    void deleteByUsername(String username);
}
