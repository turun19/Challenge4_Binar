package com.example.challenge4_binar.repository;

import com.example.challenge4_binar.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmsRepository extends JpaRepository<Films, Integer> {

}
