package com.example.challenge4_binar.controller;

import com.example.challenge4_binar.model.Films;
import com.example.challenge4_binar.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/films")
public class FilmsController {
    @Autowired
    FilmsService fs;

    @GetMapping
    public List<Films> getAll(){
        return fs.getAllFilms();
    }

    @PostMapping(value = "/film-add")
    public List<Films> addAllFilms(@RequestBody List<Films> films){
        return fs.getAddFilms(films);
    }

    @PutMapping (value = "/film-update/{film_code}")
    public List<Films> updateFilms(@PathVariable int film_code, @RequestBody List <Films> films){
        return fs.updateAllFilm(film_code, films);
    }
}
