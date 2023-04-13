package com.example.challenge4_binar.repository;

import com.example.challenge4_binar.model.Films;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmsRepository extends JpaRepository<Films, Integer> {
    @Query("SELECT f FROM Films f WHERE f.sedang_tayang_atau_tidak = :status")
    List<Films> findBySedangTayangAtauTidak(String status);

    @Query("SELECT f From Films f WHERE f.film_name = :namaFilm")
    List<Films> findAllByFilmName(String namaFilm, Pageable pageable);
}
