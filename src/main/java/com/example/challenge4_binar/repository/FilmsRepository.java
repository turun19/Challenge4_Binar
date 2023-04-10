package com.example.challenge4_binar.repository;

import com.example.challenge4_binar.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilmsRepository extends JpaRepository<Films, Integer> {

//    Optional<Films> findByIdAAndDeletedFalse(Integer integer);
}
