package com.example.challenge4_binar.service;

import com.example.challenge4_binar.model.Films;
import com.example.challenge4_binar.model.Users;
import com.example.challenge4_binar.repository.FilmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmsService {
    @Autowired
    FilmsRepository fsR;
    public List<Films> getAllFilms() {
        return fsR.findAll();
    }

    public List<Films> getAddFilms(List<Films> films) {
        List<Films> list = new ArrayList<>();

        for(Films filmsUpdate : films){
            Optional<Films> filmId = fsR.findById(filmsUpdate.getFilm_code());
            if(filmId.isPresent()){
                throw new IllegalArgumentException("Film Code " + filmsUpdate.getFilm_code() + "sudah ada");
            }else{
                list.add(fsR.save(filmsUpdate));
            }
        }
        return fsR.saveAll(list);
    }

    public List<Films> updateAllFilm(int film_code, List<Films> films) {
        List<Films> usersList = new ArrayList<>();
        for (Films filmsFromRequest : films) {
            Films filmsFromDatabase = fsR.findById(film_code).get();
            filmsFromDatabase.setFilm_name(filmsFromRequest.getFilm_name());
            filmsFromDatabase.setSedang_tayang_atau_tidak(filmsFromRequest.getSedang_tayang_atau_tidak());
            usersList.add(fsR.save(filmsFromDatabase));
        }
        return usersList;
    }
}
